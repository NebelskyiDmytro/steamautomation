package pages.steam_home;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"input_username\"]")
    public static WebElement usernameInput;
    @FindBy(xpath = "//input[@id=\"input_password\"]")
    public static WebElement passwordInput;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public static WebElement loginButton;
    @FindBy(xpath = "//div[@id=\"error_display\"]")
    public static WebElement failedLoginWindow;
    @FindBy(xpath = "//div[@class=\"login_modal loginAuthCodeModal\"]")
    public static WebElement steamGuardWindow;

    public SignInPage open() {
        open(Constant.Urls.SIGN_IN_URL);
        return this;
    }

    public SignInPage fillInUsername(String username) {
        fillFieldWithValue(usernameInput, username);
        return this;
    }

    public SignInPage fillInPassword(String pass) {
        fillFieldWithValue(passwordInput, pass);
        return this;
    }

    public void clickLogin() {
        waitElementIsClickable(loginButton);
        click(loginButton);
    }

    public void signInWithCredentials(String username, String pass, Boolean clickLogin) {
        fillInUsername(username);
        fillInPassword(pass);
        if (clickLogin) {
            click(loginButton);
        }
    }

}
