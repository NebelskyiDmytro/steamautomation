package pages.steam_app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"persona_name\"]//span[@class=\"actual_persona_name\"]")
    public static WebElement profileName;
    @FindBy(xpath = "//span[@class=\"friendPlayerLevelNum\"]")
    public static WebElement profileLevel;

    public String getProfileDisplayedName() {
        return waitElementIsVisible(profileName).getText();
    }

    public int getProfileLevel() {
        return Integer.parseInt(waitElementIsVisible(profileLevel).getText());
    }

    public void verifyDisplayedNameIs(String username) {
        Assert.assertEquals(getProfileDisplayedName(), username);
    }

    public void verifyDisplayedLevelIs(int level) {
        Assert.assertEquals(getProfileLevel(), level);
    }

}
