package tests;

import drivers.DriverFactory;
import drivers.browserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.NavbarPage;

public class CreateProject {
    WebDriver driver;
    WebDriverWait waitElement;
    String actualResult = null;
    String expectedResult = null;
    String baseUrl = "https://rendering-fabry.web.app/";
    LoginPage objLogin;
    NavbarPage objNavBar;
    CreateProjectPage objCreateProject;


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
    public void CreateProjects(){
        
        objNavBar.createLink();
        objNavBar.createLink();
        objNavBar.createProjectLink();

        objCreateProject = new CreateProjectPage(driver);
        objCreateProject.setName("Bathroom");
        objCreateProject.setCategory("Bathroom");
        objCreateProject.setPrice("300");
        objCreateProject.selectView("First");
        objCreateProject.setSubtitle("dasdasdasd");
        objCreateProject.setFirstP("adasdas");
        objCreateProject.setSecondP("objCreateProject");
        objCreateProject.setThirdP("asdsad");
        objCreateProject.setFourthP("asdasd");
        objCreateProject.setVideoLink("dasdsad");
        objCreateProject.setDescription("dasdas");
        objCreateProject.clickSubmit();
        actualResult = objCreateProject.getSuccessText();
        expectedResult = "El proyecto se ha creado correctamente, puedes verlo aqui";
        Assert.assertEquals(actualResult,expectedResult,  "Title is not equal");
    }
}

