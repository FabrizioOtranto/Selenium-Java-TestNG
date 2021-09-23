package tests;

import drivers.DriverFactory;
import drivers.browserType;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.NavbarPage;
import pages.ProjectPage;
import pages.BasePage;
import reportes.BaseClass;
import pages.EditProjectPage;


@Listeners(reportes.JyperionListener.class)
public class EditProject extends BaseClass {
		
	
	WebDriver driver;
    String actualResult = null;
    String expectedResult = null;
    String baseUrl = "https://rendering-fabry.web.app/";
    LoginPage objLogin;
    NavbarPage objNavBar;
    CreateProjectPage objCreateProject;
    ProjectPage objProject;
    EditProjectPage objEditProject;
    BasePage objWait;


    @BeforeTest
    public void setUp(){

        DriverFactory.getInstance().setDriver(browserType.CHROME);
        driver = DriverFactory.getInstance().getDriver();
        driver.get(baseUrl);
        objNavBar = new NavbarPage(driver);
        objLogin = new LoginPage(driver);
        
    }

    @AfterTest
    public void testDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void login() {
        objLogin.loginSubmit();
    }

    
    @Test(priority = 2)
    public void EditProjects(){
        objNavBar = new NavbarPage(driver);
        objNavBar.projectLink();
        objNavBar.projectLink();
        objNavBar.projectsLink();
        
        objProject = new ProjectPage(driver);
        objProject.clickEdit("61099181e86fab00158e25d0");
        
        objCreateProject = new CreateProjectPage(driver);
        objCreateProject.setName("aa");
        objCreateProject.setCategory("aa");
        objCreateProject.setPrice("ab");
        objCreateProject.selectView("aa");
        objCreateProject.setSubtitle("aa");
        objCreateProject.setFirstP("abs");
        objCreateProject.setSecondP("abs");
        objCreateProject.setThirdP("abs");
        objCreateProject.setFourthP("ab");
        objCreateProject.setVideoLink("ab");
        objCreateProject.setDescription("ab");
        
        objEditProject = new EditProjectPage(driver);
        
        objEditProject.clickEdit();
        actualResult = objEditProject.getSuccessText();
        expectedResult = "El proyecto se ha editado correctamente, puedes verlo aqui";
        Assert.assertEquals(actualResult,expectedResult,  "Title is not equal");
    }

    
}
    


