package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void fillFieldWithValue(WebElement element, String value) {
        waitElementIsClickable(element).sendKeys(value);
    }

}
