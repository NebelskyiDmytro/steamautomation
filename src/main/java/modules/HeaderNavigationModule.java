package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class HeaderNavigationModule extends BasePage {

    public HeaderNavigationModule(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id=\"logo_holder\"]//img")
    public WebElement steamLogoImage;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[1]")
    public WebElement headNavigationStore;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[2]")
    public WebElement headNavigationCommunity;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[3]")
    public WebElement headNavigationAbout;
    @FindBy(xpath = "//div[@class=\"supernav_container\"]/a[4]")
    public WebElement headNavigationSupport;

    @FindBy(xpath = "//a[@class=\"header_installsteam_btn_content\"]")
    public WebElement installSteamButton;
    @FindBy(xpath = "//a[@class=\"global_action_link\"]")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@id=\"global_actions\"]/a[contains(@href, \"https://steamcommunity.com/profiles/\")]")
    public WebElement avatarButton;

    public void clickLoginButton() {
        waitElementIsClickable(loginButton);
        loginButton.click();
    }

}
