package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;
    BasePage objBase;
    NavbarPage objNav;
    
    public By username = By.name("user");
    public By password = By.name("password");
    public By loginBtn = By.xpath("/html/body/app-root/app-login/section/div/div[2]/div/div/form/div[3]/input");
    	 

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        objBase= new BasePage(driver);
        objNav = new NavbarPage(driver);
    }

    public void setUsername(String Username){ 
    	
    	objBase.sendtext(username, Username);
    	}
    
    public void setPassword(String Password){
    	
    	objBase.sendtext(password, Password);
    }
    public void clickLogin(){
    	
    	objBase.clickElement(loginBtn);
        
    }

    public void loginSubmit(){
    	objNav.loginLink();
    	objBase.sendtext(username, "danny");
    	objBase.sendtext(password, "Danny123");
    	objBase.clickElement(loginBtn);
    }

}
