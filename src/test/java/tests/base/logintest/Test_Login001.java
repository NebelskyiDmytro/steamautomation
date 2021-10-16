package tests.base.logintest;

import common.Retry;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.steam_home.SignInPage;
import tests.base.BaseTest;

import static constants.Constant.Users.*;

public class Test_Login001 extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void loginSuccessTest() {
        welcomePage.open();
        headerNavigationModule.clickLoginButton();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithCredentials(user1Login, user1Pass, false);
    }

}
