package pages.steam_app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

public class EditProfilePage extends BasePage {

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"whiteLink persona_name_text_content\"]")
    public static WebElement displayedHeaderName;
    @FindBy(xpath = "//input[@name=\"personaName\"]")
    public static WebElement profileNameInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public static WebElement saveButton;
    @FindBy(xpath = "//div[@class=\"profileedit_HTMLErrorBox_2MfLN\"]")
    public static WebElement emptyProfileNameErrorWindow;
    @FindBy(xpath = "//div[@class=\"profileedit_HTMLErrorBox_2MfLN\"]//span")
    public static WebElement emptyProfileNameErrorText;

    public String getHeaderName() {
        return waitElementIsVisible(displayedHeaderName).getText();
    }

    public EditProfilePage verifyHeaderName(String name) {
        Assert.assertEquals(getHeaderName(), name);
        return this;
    }

    public EditProfilePage setProfileName(String name) {
        waitElementIsClickable(profileNameInput).clear();
        waitElementIsClickable(profileNameInput).sendKeys(name);
        return this;
    }

    public EditProfilePage save() {
        waitElementIsClickable(saveButton).click();
        return this;
    }

    public EditProfilePage verifyEmptyProfileNameMessageDisplayed() {
        assertElementDisplayed(emptyProfileNameErrorWindow);
        return this;
    }

}
