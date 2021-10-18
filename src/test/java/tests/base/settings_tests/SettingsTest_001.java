package tests.base.settings_tests;

import common.Retry;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.LoggerMessages.CAPTCHA_SKIP_MESSAGE;
import static constants.Constant.Users.USER1_LOGIN;
import static constants.Constant.Users.USER1_PASS;

public class SettingsTest_001 extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void emptyProfileName() {
        welcomePage.openPage();
        headerNavigationModule.clickLoginButton();
        if (signInPage.isCaptchaDisplayed()) {
            basePage.SkipTest(CAPTCHA_SKIP_MESSAGE);
        }
        signInPage.signInWithCredentials(USER1_LOGIN, USER1_PASS, true);
        headerNavigationModule.clickAvatar();
        profilePage.clickEditProfile();
        try {
            editProfilePage.verifyHeaderName(USER1_LOGIN);
        } catch (java.lang.AssertionError error) {
            System.out.println("Actual profile name is: " + editProfilePage.getHeaderName());
        }
        editProfilePage
                .setProfileName(" ")
                .save()
                .verifyEmptyProfileNameMessageDisplayed()
                .setProfileName(USER1_LOGIN);
    }

}
