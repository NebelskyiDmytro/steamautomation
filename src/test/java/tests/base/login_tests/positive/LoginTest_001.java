package tests.base.login_tests.positive;

import common.Retry;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.LoggerMessages.CAPTCHA_SKIP_MESSAGE;
import static constants.Constant.Users.*;

public class LoginTest_001 extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void loginSuccessTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        if (signInPage.isCaptchaDisplayed()) {
            basePage.SkipTest(CAPTCHA_SKIP_MESSAGE);
        }
        signInPage.signInWithCredentials(USER1_LOGIN, USER1_PASS, true);
        headerNavigationModule.verifyUserIs(USER1_LOGIN);
        headerNavigationModule.clickAvatar();
        profilePage.verifyDisplayedNameIs(USER1_LOGIN);
        profilePage.verifyDisplayedLevelIs(0);
    }

    @Test(retryAnalyzer = Retry.class)
    public void steamGuardTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        if (signInPage.isCaptchaDisplayed()) {
            basePage.SkipTest(CAPTCHA_SKIP_MESSAGE);
        }
        signInPage.signInWithCredentials(USER2_LOGIN, USER2_PASS, true);
        signInPage.verifySteamGuardDisplayed();
    }

}
