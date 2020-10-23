package com.analytics.qa.testcases;

import com.analytics.qa.base.TestBase;
import com.analytics.qa.page.LoginPage;
import com.analytics.qa.page.SignUpPage;
import com.analytics.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignUpPageTest extends TestBase {

    LoginPage loginPage;
    TestUtil testUtil ;
    SignUpPage signUpPage;

    public SignUpPageTest() {
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
        Assert.assertEquals(title,"IMDb TV: Watch TV Shows and Movies Online for Free - IMDb");
    }

    @Test(alwaysRun=true, groups = {"Regression","LocalTest","SmokeTest"})
    public void LogoImageTest(){
        boolean flag = loginPage.validateLogoDisplay();
        Assert.assertTrue(flag);
    }


}
