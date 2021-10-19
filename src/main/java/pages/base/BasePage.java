package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import static constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void SkipTest(String message) {
        throw new SkipException(message);
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public void assertElementDisplayed(WebElement element) {
        try {
            waitElementIsVisible(element);
            Assert.assertTrue(element.isDisplayed());
        } catch (org.openqa.selenium.TimeoutException e) {
            Assert.fail(e.getLocalizedMessage());
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public WebElement findElementStringFormat(String path, String value) {
        return driver.findElement(By.xpath(String.format(path, value)));
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementIsPresent(By element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element);
    }

    public WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement waitForElementAttributeToBe(WebElement element, String attr, String value) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.attributeToBe(element, attr, value));
        return element;
    }

    public String getElementAttributeValue(WebElement element, String attr) {
        return element.getAttribute(attr);
    }

    public void fillFieldWithValue(WebElement element, String value) {
        waitElementIsClickable(element).sendKeys(value);
    }

}
