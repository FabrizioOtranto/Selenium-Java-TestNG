package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateProjectPage extends BasePage {
    WebDriver driver;
    BasePage objBase;
   


    public By name = By.name("name");

    public By category = By.name("category");
    
    public By price = By.name("price");

    public By view = By.name("view");

    public By subtitle = By.name("subtitle");

    public By firstP = By.name("name");@FindBy(name = "firstP")
   
    public By secondP = By.name("secondP");
    
    public By thirdP = By.name("thirdP");
 
    public By fourthP = By.name("fourthP");

    public By video = By.name("name");

    public By description = By.name("message");
    
    public By registerBtn = By.xpath("/html/body/app-root/app-create/section/div/form/button");

    public By message = By.className("success");

    public By clickhere = By.xpath("/html/body/app-root/app-create/section/div/div[2]/span/a");
    
    public  CreateProjectPage(WebDriver driver){
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        objBase= new BasePage(driver);
    
    }

    public void setName(String Name) { 
    	objBase.clear(name);
    	objBase.sendtext(name, Name);

    	}
    public void setCategory(String Category){
    	objBase.clear(category);
    	objBase.sendtext(category, Category);

    	}
    public void setPrice(String Price){
    	objBase.clear(price);
    	objBase.sendtext(price, Price);

    	}
    public void setSubtitle(String Subtitle){
    	objBase.clear(subtitle);
    	objBase.sendtext(subtitle, Subtitle);

    	}
    public void setFirstP(String Fp){ 
    	objBase.clear(firstP);
    	objBase.sendtext(firstP, Fp);
 
    	}
    public void setSecondP(String Sp){
    	objBase.clear(secondP);
    	objBase.sendtext(secondP, Sp);
    	}
    public void setThirdP(String Tp){ 
    	objBase.clear(thirdP);
    	objBase.sendtext(thirdP, Tp);
    	}
    public void setFourthP(String Fph){
    	objBase.clear(fourthP);
    	objBase.sendtext(fourthP, Fph);

    	}
    
    public void setVideoLink(String Video){
    	objBase.clear(video);
    	objBase.sendtext(video, Video);

    	}

    	
    public void setDescription(String Description){
    	objBase.clear(description);
    	objBase.sendtext(description, Description);

    	}
    public void selectView(String View){
    	objBase.sendtext(view, View);
    	}
    public void clickSubmit(){
    	objBase.clickElement(registerBtn);
       
    	}
    public String getSuccessText(){
    	return objBase.getText(message);
    	}

}
