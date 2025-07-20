package Module1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.BrowserWindowsPage; // ✅ Import your POM class

public class WindowPopupTest {

    WebDriver driver; // ✅ Class-level
    BrowserWindowsPage browserWindowsPage;

    @BeforeClass
    public void setup() {
       // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe"); // ✅ Make sure path is correct
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    @Test
    public void testChildWindowHandling() {
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        String parentWindow = browserWindowsPage.getCurrentWindowHandle();
        browserWindowsPage.clickNewWindowButton();

        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                browserWindowsPage.switchToWindow(win);
                System.out.println("Child Window Title: " + browserWindowsPage.getCurrentTitle());
                browserWindowsPage.closeCurrentWindow();
            }
        }

        browserWindowsPage.switchToWindow(parentWindow);
        System.out.println("Back to Parent Title: " + browserWindowsPage.getCurrentTitle());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
