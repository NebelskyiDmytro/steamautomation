package common;

public class Config {

    public static final int MAX_FAIL_RETRY = 2;

    public static final String PLATFORM_AND_BROWSER = "win_chrome";

    /**
     * To keep the browser open after suite
     * if true - browser close
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    /**
     * Clear browser cookies and local storage after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    /**
     * To keep the console log to be more clear
     * if true - chrome will not log
     */
    public static final Boolean CHROME_CLIENT_LOG = true;

}
