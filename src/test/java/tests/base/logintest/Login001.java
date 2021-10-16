package tests.base.logintest;

import common.Retry;
import org.omg.IOP.TAG_JAVA_CODEBASE;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.steam_app.ProfilePage;
import pages.steam_app.SignInPage;
import tests.base.BaseTest;

import static constants.Constant.ErrorMessages.*;
import static constants.Constant.Users.*;

public class Login001 extends BaseTest {

    @Test
    public void loginSuccessTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithCredentials(user1Login, user1Pass, true);
        Assert.assertEquals(headerNavigationModule.getLoggedAccountName(), user1Login);
        headerNavigationModule.clickAvatar();
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        Assert.assertEquals(profilePage.getProfileDisplayedName(), user1Login);
        Assert.assertEquals(profilePage.getProfileLevel(), 0);
    }

    @Test
    public void loginFailedTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithCredentials(user1Login, "incorrectPassword", true);
        Assert.assertEquals(basePage.getElementAttributeValue(signInPage.failedLoginWindow, "style"), LOGIN_ERROR);
    }

}
