package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

public class HeaderNavigationModule extends BasePage {

    public HeaderNavigationModule(WebDriver driver) {
        super(driver);
    }

    private static final By accountName = By.xpath("//span[@class=\"persona online\"]");
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
    @FindBy(xpath = "//span[@id=\"account_pulldown\"]")
    public static WebElement accountPulldown;
    @FindBy(xpath = "//div[@id=\"global_actions\"]/a[contains(@href, \"https://steamcommunity.com/profiles/\")]")
    public static WebElement avatarButton;
    @FindBy(id = "language_pulldown")
    public static WebElement languagePulldown;

    private static final String languageDropdownValue = "//div[@id=\"language_dropdown\"]//a[contains(text(), \"%s\")]";

    public void clickLoginButton() {
        waitElementIsClickable(loginButton).click();
    }

    public String getProfileName() {
        return waitElementIsVisible(accountPulldown).getText();
    }

    public String getAccountName() {
        return waitElementIsPresent(accountName).getAttribute("innerText");
    }

    public void clickAvatar() {
        waitElementIsClickable(avatarButton).click();
    }

    public void verifyProfileNameIs(String username) {
        Assert.assertEquals(getProfileName(), username);
    }

    public void verifyAccountNameIs(String username) {
        Assert.assertEquals(getAccountName(), username);
    }

    public void changeLanguage(String language) {
        waitElementIsClickable(languagePulldown).click();
        waitElementIsClickable(findElementStringFormat(languageDropdownValue, language)).click();
    }

}
