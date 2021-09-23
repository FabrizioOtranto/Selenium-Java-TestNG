package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class NavbarPage {
    WebDriver driver;
    BasePage objBase;

    public By index = By.id("logo");

    public By portfolio = By.id("portfolio");

    public By dropdown = By.id("dropdown");

    public By login = By.id("login");
    
    public By price = By.id("price");

    public By about = By.id("about");

    public By contact = By.id("contact");
      
    public By create = By.id("create");
    
    public By createProject = By.id("createp");

    public By creatMiniProject = By.id("createmp");
    
    public By project = By.id("project");

    public By projects = By.id("projects");

    public By miniProjects = By.id("miniprojects");
    
    public By message = By.id("messages");
    
    public By logout = By.id("logout");

    public By twitter = By.id("twitter");
    
    public By facebook = By.id("facebook");
    
    public By instagram = By.id("instagram");
   
    public By whatsapp = By.id("whatsapp");

    public  NavbarPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
        objBase= new BasePage(driver);
    }

    public void indexLink(){
    	objBase.clickElement(index); 
    	}

    public void portoflioLink(){
    	objBase.clickElement(portfolio);
    }

    public void dropdownLink(){
    	objBase.clickElement(dropdown);
    }

    public void loginLink(){
    	objBase.clickElement(login);
    }

    public void priceLink(){
    	objBase.clickElement(price);
    }
    public void aboutLink(){
    	objBase.clickElement(about);
    }

    public void contactLink(){
    	objBase.clickElement(contact);
    }
    
    public void createLink(){
       objBase.clickElement(create);
    }

    public void createProjectLink(){

    	objBase.clickElement(createProject); 
        }

    public void createMiniProjectLink(){
       
    	objBase.clickElement(creatMiniProject);
        }

    public void projectLink(){        
    	objBase.clickElement(project);
        }

    
    public void projectsLink(){        
    	objBase.clickElement(projects); 
        }

    public void miniProjectsLink(){      
    	objBase.clickElement(miniProjects); 
        }

    public void mesageLink(){
    	objBase.clickElement(message);   
    }

    public void twitterLink(){
    	objBase.clickElement(twitter); 
    }

    public void facebookLink(){
    	objBase.clickElement(facebook); 
    }

    public void instagramLink(){
    	objBase.clickElement(instagram); 
    }

    public void whatsappLink(){
    	objBase.clickElement(whatsapp); 
    }

    public void logoutLink(){
    	objBase.clickElement(logout); 
    }

}
