package com.analytics.qa.base ;

import com.analytics.qa.util.TestUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();
    public Properties prop;
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;


    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/ssawhney/IntelliJ-workspace/AmazonWebSite/src/main/resources/config.properties");
            prop.load(ip);
            System.out.println(prop);
            System.out.println(prop.getProperty("url_prop"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void initialization(String browser, String url) throws MalformedURLException {
        // driver.set(new RemoteWebDriver(new URL("http://192.168.1.21:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));


        if (browser.equals("firefox")) {
            driver.set(new FirefoxDriver());
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        }

        if (browser.equals("chrome")) {
            driver.set(new ChromeDriver());
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        }



        getDriver().manage().window().maximize();
        //getDriver().manage().logs().get(LogType.BROWSER);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        for (int attempts = 0; attempts < 2; attempts++) {
            try {
                getDriver().get(prop.getProperty("url_prop"));
                break;
            } catch (NullPointerException e) {
                System.out.println("Exception" + e);
                continue;

            }
        }
    }





}








