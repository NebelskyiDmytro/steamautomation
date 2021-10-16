package modules;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

public class HeaderNavigationModule extends BasePage {

    public HeaderNavigationModule(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id=\"logo_holder\"]//img")
    public static WebElement steamLogoImage;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[1]")
    public static WebElement headNavigationStore;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[2]")
    public static WebElement headNavigationCommunity;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[3]")
    public static WebElement headNavigationAbout;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[4]")
    public static WebElement headNavigationSupport;

    @FindBy(xpath = "//a[@class=\"header_installsteam_btn_content\"]")
    public static WebElement installSteamButton;
    @FindBy(xpath = "//a[@class=\"global_action_link\"]")
    public static WebElement loginButton;
    @FindBy(xpath = "//div[@id=\"global_actions\"]/a[contains(@href, \"https://steamcommunity.com/profiles/\")]")
    public static WebElement avatarButton;

    public void clickLoginButton() {
        waitElementIsClickable(loginButton);
        click(loginButton);
        Assert.assertEquals(getCurrentTitle(), Constant.Urls.SIGN_IN_TITLE);
    }

}
