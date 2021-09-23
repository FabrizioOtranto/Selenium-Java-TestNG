package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    // General utility methods


    public List<WebElement> getWebElementList(By element) {
        return driver.findElements(element);
    }

    // Waits

    public void waitForElementToBeClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToDisappear(By locator) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForAnnouncementText(By locator, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForElementToBeVisible(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated((By) locator));
    }
      
    public void waitForVisibleText(By locator) {
        getWait().until(ExpectedConditions.invisibilityOfElementWithText(locator, null));
    }
    
  public void waitForVisibleText2(By locator) {
	  getWait().until((ExpectedCondition<Boolean>) driver -> driver.findElement(locator).getAttribute("value").length() != 0);
  }

    public WebDriverWait getWait() {
        return this.wait;
    }
    
    public void clickElement(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }
    
    public void sendtext(By locator, String text) {
    	waitForElementToBeVisible(locator);
    	this.driver.findElement(locator).sendKeys(text);
    }
    
    public void clear(By locator) {
    	waitForElementToBeVisible(locator);
    	this.driver.findElement(locator).clear();
    	
    }
    
    public String getText(By locator) {
    	waitForElementToBeVisible(locator);
    	return this.driver.findElement(locator).getText();
    	
    }

}