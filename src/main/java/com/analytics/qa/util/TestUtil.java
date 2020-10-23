package com.analytics.qa.util;

import com.analytics.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestUtil extends TestBase {

    public static long IMPLICIT_WAIT = 5000;
    public static long PAGELOADTIMEOUT = 5000;
    private JavascriptExecutor executor = (JavascriptExecutor) getDriver();


    /*** Get Logs from Browser Console ***/
    public List<LogEntry> getBrowserLogs() {
        LogEntries log = getDriver().manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;

    }

    public void JSErrorListener() {
        SoftAssert softAssert = new SoftAssert();
        //Get Logs

        List<LogEntry> logs = getBrowserLogs();
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe Error:" + logEntry.getMessage());
            }
        }
        softAssert.assertAll();

    }

    public void waitImplicitly() {
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    public void PageLoadTimeOut() {
        getDriver().manage().timeouts().pageLoadTimeout(PAGELOADTIMEOUT, TimeUnit.SECONDS);

    }

    public void waitFor(ExpectedCondition<WebElement> condition) {
        // timeOutInSeconds = timeOutInSeconds !=null ? timeOutInSeconds : 30 ;
        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        wait.until(condition);
    }

    public void waitForList(ExpectedCondition<List<WebElement>> condition) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        System.out.println("I came here 1");
        wait.until(condition);
    }


    public void actionMoveTo(WebElement abc) {
        System.out.println("abc" + abc);
        //timeOutInSeconds = timeOutInSeconds !=null ? timeOutInSeconds : 30 ;
        Actions act = new Actions(getDriver());
        act.moveToElement(abc).build().perform();
    }


    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 50);
        wait.until(new Function<WebDriver, Boolean>() {

            public Boolean apply(WebDriver driver) {

                           if (executor.executeScript("return document.readyState").toString().equals("complete")) {
                               System.out.println("Page Is loaded.");
                           }

                           return String.valueOf((executor).executeScript("return document.readyState")).equals("complete");
                       }
                   }
        );


    }
}