package com.analytics.qa.testcases;

import com.analytics.qa.base.TestBase;
import com.analytics.qa.page.LoginPage;
import com.analytics.qa.page.SignUpPage;
import com.analytics.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginPageTest extends TestBase {

    LoginPage loginPage ;
    TestUtil testUtil ;
    SignUpPage signUpPage ;

    public LoginPageTest() {
        super();
    }

    @Parameters({ "browser","username","password","url"})
    @BeforeMethod(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void setUp(String browser, String username, String password, String url) throws MalformedURLException {
        initialization(browser,url);
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        signUpPage = new SignUpPage();
        testUtil.waitImplicitly();
        testUtil.PageLoadTimeOut();
        testUtil.waitForPageLoad();
    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title,"IMDb TV: Watch TV Shows and Movies Online for Free - IMDb");
    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void LogoImageTest(){
        boolean flag = loginPage.validateLogoDisplay();
        Assert.assertTrue(flag);
    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void ArrowClickTest() {
        loginPage.validateArrowClick();
    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void MovieTextRealSteelTest() throws InterruptedException{
       String text = loginPage.validateMovieTextRealSteel();
       Assert.assertEquals(text,"Real Steel");

    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void ClickAndVerifySignUpTextTest() throws InterruptedException{
        String text= loginPage.validateClickAndVerifySignUpText();
        Assert.assertEquals(text,"Sign in");
    }


    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"}) //Page Chaining
    public void ClickOnMovieRealSteelTest() throws InterruptedException{
        signUpPage = loginPage.validateClickOnMovieRealSteel();

    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void JSErrorTest() throws InterruptedException{
        testUtil.JSErrorListener();
    }

    @AfterMethod(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void tearDown() throws InterruptedException
    {
        getDriver().quit();
        Thread.sleep(2000);
    }



}

