package com.analytics.qa.page;

import com.analytics.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    WebElement SignUpText;

    public SignUpPage() {
            PageFactory.initElements(getDriver(), this);
}

    public String validateSignUpText() {
        return SignUpText.getText();
    }


}
