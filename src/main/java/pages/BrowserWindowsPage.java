package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage {

	 WebDriver driver;

	    // Constructor
	    public BrowserWindowsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    private By newWindowButton = By.id("windowButton");

	    // Actions
	    public void clickNewWindowButton() {
	        driver.findElement(newWindowButton).click();
	    }

	    public String getCurrentTitle() {
	        return driver.getTitle();
	    }

	    public String getCurrentWindowHandle() {
	        return driver.getWindowHandle();
	    }

	    public void switchToWindow(String windowHandle) {
	        driver.switchTo().window(windowHandle);
	    }

	    public void closeCurrentWindow() {
	        driver.close();
	    }
	
	
	
}
