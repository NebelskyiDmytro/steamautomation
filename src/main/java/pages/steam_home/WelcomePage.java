package pages.steam_home;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public WelcomePage open() {
        open(Constant.Urls.STEAM_WELCOME_URL);
        Assert.assertEquals(getCurrentTitle(), Constant.Urls.STEAM_WELCOME_TITLE);
        return this;
    }

}
