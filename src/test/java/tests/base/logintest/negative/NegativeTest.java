package tests.base.logintest.negative;

import common.Retry;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.annotations.Test;
import pages.steam_app.SignInPage;
import tests.base.BaseTest;

import static constants.Constant.ErrorMessages.LOGIN_ERROR;
import static constants.Constant.Users.USER1_LOGIN;

public class NegativeTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void loginFailedTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        if (basePage.isElementDisplayed(signInPage.captchaImage)) {
            throw new SkipException("Captcha is displayed. Test execution is skipped");
        }
        signInPage.signInWithCredentials(USER1_LOGIN, "incorrectPassword", true);
        basePage.waitForElementAttributeToBe(signInPage.failedLoginWindow, "style", LOGIN_ERROR);
        Assert.assertEquals(basePage.getElementAttributeValue(signInPage.failedLoginWindow, "style"), LOGIN_ERROR);
    }

}
