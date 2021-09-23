package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import drivers.DriverFactory;
import drivers.browserType;
import pages.CreateProjectPage;
import pages.EditProjectPage;
import pages.LoginPage;
import pages.NavbarPage;
import pages.ProjectPage;
import pages.BasePage;

public class DeleteProject {
	WebDriver driver;
    WebDriverWait waitElement;
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
        waitElement = new WebDriverWait(driver, 15);
        objNavBar = new NavbarPage(driver);
        objLogin = new LoginPage(driver);
        objProject = new ProjectPage(driver);
        objEditProject = new EditProjectPage(driver);
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
    public void EditProject(){
        objNavBar.projectLink();
        objNavBar.projectLink();
        objNavBar.projectsLink();
        
        actualResult = objProject.verifyProjectTitle("1");
        expectedResult = "Interior Rendering";
        Assert.assertEquals(actualResult,expectedResult);
        objProject.clickEdit("61099181e86fab00158e25d0");
        
        objEditProject.clickDelete();
        objEditProject.clickConfirmDelete();
        actualResult = objProject.verifyTitle();
        //expectedResult = "Your Projects";
        //Assert.assertEquals(actualResult,expectedResult,  "Title is not equal");
    }
}


