package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMiniProject {
    WebDriver driver;

    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "category")
    WebElement category;
    @FindBy(name = "view")
    WebElement view;
    @FindBy(name = "description")
    WebElement description;
    @FindBy(xpath = "/html/body/app-root/app-createminiproject/section/div/form/button")
    WebElement submit;
    @FindBy(className = "success")
    WebElement message;
    @FindBy(xpath = "/html/body/app-root/app-createminiproject/section/div/div[2]/span/a")
    WebElement linkHere;
}

