package tests.base.logintest.negative;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.LoggerMessages.CAPTCHA_SKIP_MESSAGE;
import static constants.Constant.Users.USER1_LOGIN;

public class NegativeTest extends BaseTest {

    @Test
    public void loginFailedTest() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        if (signInPage.isCaptchaDisplayed()) {
            basePage.SkipTest(CAPTCHA_SKIP_MESSAGE);
        }
        signInPage.signInWithCredentials(USER1_LOGIN, "000000", true);
        signInPage.verifyFailedLoginDisplayed();
    }

}
