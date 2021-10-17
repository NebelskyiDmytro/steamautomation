package tests.base.logintest.positive;

import common.Retry;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.steam_app.ProfilePage;
import pages.steam_app.SignInPage;
import tests.base.BaseTest;

import static constants.Constant.Users.USER1_LOGIN;
import static constants.Constant.Users.USER1_PASS;

public class PositiveTest extends BaseTest {

    @Test
    public void loginSuccessTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        if (basePage.isElementDisplayed(signInPage.captchaImage)) {
            throw new SkipException("Captcha is displayed. Test execution is skipped");
        }
        signInPage.signInWithCredentials(USER1_LOGIN, USER1_PASS, true);
        Assert.assertEquals(headerNavigationModule.getLoggedAccountName(), USER1_LOGIN);
        headerNavigationModule.clickAvatar();
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        Assert.assertEquals(profilePage.getProfileDisplayedName(), USER1_LOGIN);
        Assert.assertEquals(profilePage.getProfileLevel(), 0);
    }

}
