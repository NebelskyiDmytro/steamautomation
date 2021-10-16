package tests.base.logintest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class Test_Login001 extends BaseTest {

    @Test
    public void loginSuccessTest() {
        basePage.open("https://store.steampowered.com/");
    }

}
