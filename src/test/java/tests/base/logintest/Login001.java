package tests.base.logintest;

import common.Retry;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.steam_app.ProfilePage;
import pages.steam_app.SignInPage;
import tests.base.BaseTest;

import static constants.Constant.ErrorMessages.*;
import static constants.Constant.Users.*;

public class Login001 extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void loginSuccessTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithCredentials(USER1_LOGIN, USER1_PASS, true);
        Assert.assertEquals(headerNavigationModule.getLoggedAccountName(), USER1_LOGIN);
        headerNavigationModule.clickAvatar();
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        Assert.assertEquals(profilePage.getProfileDisplayedName(), USER1_LOGIN);
        Assert.assertEquals(profilePage.getProfileLevel(), 0);
    }

    @Test(retryAnalyzer = Retry.class)
    public void loginFailedTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithCredentials(USER1_LOGIN, "incorrectPassword", true);
        basePage.waitForElementAttributeToBe(signInPage.failedLoginWindow, "style", LOGIN_ERROR);
        Assert.assertEquals(basePage.getElementAttributeValue(signInPage.failedLoginWindow, "style"), LOGIN_ERROR);
    }

}
