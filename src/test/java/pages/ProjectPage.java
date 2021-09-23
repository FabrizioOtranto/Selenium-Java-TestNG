package pages;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectPage {
	WebDriver driver;
	BasePage objBase;
	
	 
	 
	 public By title = By.xpath("/html/body/app-root/app-projects-admin/section/div/div[1]/p");
	 
	public  ProjectPage(WebDriver driver) {
        this.driver = driver;
        objBase = new BasePage(driver);
        
        PageFactory.initElements(driver, this);
    }

    public String verifyTitle(){ 
    	return objBase.getText(title);
    	}
    
    public String verifyProjectTitle(String index){ 
    	By projectTitle = By.xpath(String.format("*//section/div/div[2]/main/div/div/ul/li[%s]/div/div/p/strong", index));
    	
    	return objBase.getText(projectTitle);
    	}
    
    public void clickEdit(String id){
    	By edit = By.xpath(String.format("//a[@href='/edit/project/%s']",id));
    	objBase.clickElement(edit);
    	}
    
    
}
