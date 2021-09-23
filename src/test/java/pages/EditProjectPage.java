package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProjectPage {
	WebDriver driver;
	BasePage objBase;
	

	public By chooseFile = By.xpath("//input[@type='file']");
	
	public By edit = By.className("btn-edit");
	
	public By delete = By.className("btn-borrar");
	
	public By cancel = By.xpath("//*[text() = 'cancelar']");
	
	public By confirmDelete =  By.className("btn-danger");
	
	public By deleteImage =  By.className("btn-edit-image");
	
	
	
	public By message = By.className("success");

    
	 


	 public  EditProjectPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        objBase = new BasePage(driver);
	    }
	
	    public void clickChooseFile(){ 
	    	objBase.clickElement(chooseFile);
	    	}
	    
	    public void clickEdit(){ 
	    	objBase.clickElement(edit);
	    	}
	    
	    public void  clickDelete(){ 
	    	objBase.clickElement(delete);
	    	}
	 
	    public void  clickConfirmDelete(){ 
	    	objBase.clickElement(confirmDelete);
	    	}
	    
	    public void  clickCancel(){ 
	    	objBase.clickElement(cancel);
	    	}
	    
	    public void setImageDelete( String Images){ 
	    	objBase.clear(deleteImage);
	    	objBase.sendtext(deleteImage, Images);
	    	}
	    
	    public void  clickDeleteImage(){ 
	    	objBase.clickElement(edit); 
	    	}
	    
	    public String getSuccessText(){
	        return objBase.getText(message);
	    	}
}
