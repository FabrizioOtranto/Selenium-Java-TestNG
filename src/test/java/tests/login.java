package tests;

import drivers.DriverFactory;
import drivers.browserType;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavbarPage;
import reportes.videoReport;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;


public class login {
    WebDriver driver;
    WebDriverWait waitElement;
    String actualResult = null;
    String expectedResult = null;
    String baseUrl = "https://rendering-fabry.web.app/";
    LoginPage objLogin;
    NavbarPage objNavBar;

    private ScreenRecorder screenRecorder;

    public void stopRecording() throws IOException {
        this.screenRecorder.stop();
    }

    public void startRecording(String videoPath) throws IOException, AWTException {
        File file = new File(videoPath);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(0, 0, 1920, 1000);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        this.screenRecorder = new videoReport(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15*60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, "CP001" + new Random().nextInt());
        this.screenRecorder.start();
    }

    @BeforeTest
    public void setUp() throws IOException, AWTException{
        DriverFactory.getInstance().setDriver(browserType.CHROME);
        driver = DriverFactory.getInstance().getDriver();
        driver.get(baseUrl);
        objNavBar = new NavbarPage(driver);
        objLogin = new LoginPage(driver);
        startRecording(System.getProperty("user.dir") + "\\video\\");
        
    }

    @AfterTest
    public void testDown() throws IOException {
        driver.quit();
        stopRecording();
    }

    @Test(priority = 1)
    public void logins() throws IOException {
        objNavBar.loginLink();
        objLogin.setUsername("danny");
        objLogin.setPassword("Danny123");
        objLogin.clickLogin();
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File("C:\\Users\\fabry\\IdeaProjects\\Rendering\\screenshot\\loginPhoto.png"));
    }
}

