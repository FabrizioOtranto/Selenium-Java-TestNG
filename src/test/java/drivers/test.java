package drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
    WebDriver driver;
    WebDriverWait waitElement;
    String baseUrl = "https://rendering-fabry.web.app/index";
    String actualResult = "";
    String expectedResult = "";

    @BeforeTest
    public void setUpttest(){
        DriverFactory.getInstance().setDriver(browserType.EDGE);
        driver = DriverFactory.getInstance().getDriver();
        driver.get(baseUrl);
        waitElement = new WebDriverWait(driver, 15);
    }

    @AfterTest
    public void testDown(){
        DriverFactory.getInstance().removeDriver();
    }

    @Test ()
    public void Login(){
        driver.findElement(By.xpath("/html/body/app-root/app-navbar/nav/div/div[2]/ul/li[2]/a/p")).click();
        WebElement user = driver.findElement(By.name("user"));
        user.clear();
        user.sendKeys("Danny");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("Danny123");
        driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/div/div/form/div[3]/input")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-index/section/div[1]/div/div/div/div[1]/span/p[1]/strong")));
        actualResult = driver.findElement(By.xpath("/html/body/app-root/app-index/section/div[1]/div/div/div/div[1]/span/p[1]/strong")).getText();
        expectedResult = "Helping You to Visualise in 3D at Affordable Prices";
        Assert.assertEquals(actualResult,expectedResult,  "Title is not equal");
    }
    }

