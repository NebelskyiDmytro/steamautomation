package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static common.Config.MAX_FAIL_RETRY;

public class Retry implements IRetryAnalyzer {

    private static int actualRetry = 0;

    public boolean retry(ITestResult result) {
        if (actualRetry < MAX_FAIL_RETRY) {
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }

}
