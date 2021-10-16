package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver() {

        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                System.setProperty("webdriver.chromedriver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect value of PLATFORM_AND_BROWSER" + PLATFORM_AND_BROWSER);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;

    }

}
