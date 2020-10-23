package com.analytics.qa.page;

import com.analytics.qa.base.TestBase;
import com.analytics.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends TestBase {


    TestUtil testUtil = new TestUtil();
    SignUpPage signUpPage = new SignUpPage();

    @FindBy(xpath = "//a[@id='home_img_holder']")
    WebElement Logo;

    @FindAll(@FindBy(xpath = "//button[@class='freedive-next-button slick-arrow']"))
    List<WebElement> ListofArrows;

    @FindBy(xpath = "//*[@title='Real Steel']")
    WebElement MovieTextRealSteel;

    @FindBy(xpath = "//*[@class='slick-slide slick-active' and @data-slick-index='8']/div/div/figure/div/a/*[name()='svg' and @class='freedive-titlePoster__play-icon']")
    WebElement ClickOnMovieRealSteel;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateLoginPageTitle() {
        return getDriver().getTitle();
    }

    public boolean validateLogoDisplay() {
        return Logo.isDisplayed();
    }

    public void validateArrowClick() {
        testUtil.waitForList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='freedive-next-button slick-arrow']")));
        ListofArrows.get(0).click();
    }

    public String validateMovieTextRealSteel() {
        testUtil.waitForList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='freedive-next-button slick-arrow']")));
        ListofArrows.get(0).click();
        testUtil.waitFor(ExpectedConditions.visibilityOf(MovieTextRealSteel));
        return MovieTextRealSteel.getText();
    }

    public SignUpPage validateClickOnMovieRealSteel() throws InterruptedException {
        testUtil.waitForList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='freedive-next-button slick-arrow']")));
        ListofArrows.get(0).click();
        testUtil.waitFor(ExpectedConditions.visibilityOf(MovieTextRealSteel));
        testUtil.actionMoveTo(MovieTextRealSteel);
        ClickOnMovieRealSteel.click();
        testUtil.PageLoadTimeOut();
        return new SignUpPage();

    }


    public String validateClickAndVerifySignUpText() throws InterruptedException {
        testUtil.waitForList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='freedive-next-button slick-arrow']")));
        ListofArrows.get(0).click();
        testUtil.waitFor(ExpectedConditions.visibilityOf(MovieTextRealSteel));
        testUtil.actionMoveTo(MovieTextRealSteel);
        ClickOnMovieRealSteel.click();
        testUtil.PageLoadTimeOut();
        return signUpPage.validateSignUpText();

    }


}





