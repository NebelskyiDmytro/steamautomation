package pages.steam_app;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import static common.Config.CHROME_LANGUAGE;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public WelcomePage openPage() {
        switch (CHROME_LANGUAGE) {
            case "ru":
                open(Constant.Urls.STEAM_WELCOME_URL);
                Assert.assertEquals(getCurrentTitle(), Constant.Urls.STEAM_WELCOME_TITLE_RU);
                break;
            case "en":
                open(Constant.Urls.STEAM_WELCOME_URL);
                Assert.assertEquals(getCurrentTitle(), Constant.Urls.STEAM_WELCOME_TITLE_EN);
                break;
            case "uk":
                open(Constant.Urls.STEAM_WELCOME_URL);
                Assert.assertEquals(getCurrentTitle(), Constant.Urls.STEAM_WELCOME_TITLE_UA);
                break;
        }
        return this;
    }

}
