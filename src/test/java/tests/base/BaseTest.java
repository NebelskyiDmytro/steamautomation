package tests.base;

import common.CommonActions;
import modules.HeaderNavigationModule;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.steam_app.WelcomePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.TimeoutVariables.THREAD_SLEEP;

public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();

    protected BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    protected WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
    protected HeaderNavigationModule headerNavigationModule = PageFactory.initElements(driver, HeaderNavigationModule.class);

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (!HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }

    @AfterMethod
    public void waitAfterMethod() throws InterruptedException {
        if (THREAD_SLEEP > 0) {
            Thread.sleep(THREAD_SLEEP * 1000);
        } else {
            Assert.fail("THREAD_SLEEP variable should be greater than zero");
        }
    }

}
