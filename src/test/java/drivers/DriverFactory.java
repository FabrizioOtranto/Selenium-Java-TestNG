package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private DriverFactory(){

    }
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
      @Override
      protected WebDriver initialValue(){
          return null;
      }
    };

    public WebDriver getDriver(){
        return driver.get();
    }
    public WebDriver setDriver(drivers.browserType browser){
        String osName = System.getProperty("os.name").toLowerCase().contains("mac")?"mac": " windows ";
        String driverPath = "C:\\drivers\\";

        switch(browser.toString()){
            case "CHROME":
                if(osName.equals("mac")){
                    System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver");
                }else{
                    System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver.exe");
                }
                driver.set(new ChromeDriver());
                break;
            case "FIREFOX":
                if(osName.equals("mac")){
                    System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver");
                }else{
                    System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
                }
                driver.set(new FirefoxDriver());
                break;
            case "EDGE":
                if(osName.equals("mac")){
                    System.setProperty("webdriver.edge.driver", driverPath+ "msedgedriver");
                }else{
                    System.setProperty("webdriver.edge.driver", driverPath+ "msedgedriver.exe");
                }
                driver.set(new EdgeDriver());
                break;
        }
        int i = 10;
        for (int j=1; j<= i; j++) {
            try {
                driver.get().manage().window().maximize();
                break;
            } catch (WebDriverException we) {
                driver.set(new ChromeDriver());
                driver.get().manage().window().maximize();
            }
            if (i == j) {
                Assert.fail("Failed to maximize windows " + j + "times");
            }
        }
    driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver.get();
        }
        public void removeDriver(){
                driver.get().quit();
                driver.remove();
    }
    }

