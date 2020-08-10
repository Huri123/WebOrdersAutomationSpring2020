package com.weborders.utilities;
//burda singleton design olusturduk.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
 */

public class Driver {

    private static WebDriver driver; //private cunku This class should not be instantiated.
    /* bunlari vasyl ekledi selenium grid icin
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;
    private static URL url;
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
     */

    private Driver() {
        //Driver driver = new Driver();//yani boyle hic kimse yapamamali. instantiate yapamamali.//Nobody should create object of this class
    }

    public static WebDriver getDriver() { //static olmasaydi bu classtan object olusturmamiz lazimdi.Bunu istemiyorsak static yapmamiz lazim

        String browser = ConfigurationReader.getProperty("browser");
        if (driver == null) {
            switch (browser) {
                case "chrome":
                case "CHROME":
                case "chrome-browser":
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();  //driver = new ChromeDriver(); we instantiate the object.
                    break;
               /* bunlari vasyl ekledi selenium grid icin
                case "remote-chrome":
                    chromeOptions = new ChromeOptions();
                    try {
                        URL url = new URL("http://100.25.110.24:4444/wd/hub");
                        driverPool.set(new RemoteWebDriver(url,chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                     break;

                case "remote-firefox":
                    firefoxOptions = new FirefoxOptions();
                    try {
                        URL url = new URL("http://100.25.110.24:4444/wd/hub");
                        driverPool.set(new RemoteWebDriver(url,firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                */
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

/*
Vasyl'in Kodlari:

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Driver {
    private static WebDriver driver;
    private Driver(){
    }
    public static WebDriver getDriver(){
        String browser = ConfigurationReader.getProperty("browser");
        if (driver == null) {
            switch (browser) {
                case "chrome":
                case "CHROME":
                case "chrome-browser":
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
 */


