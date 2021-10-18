package common;

public class Config {

    public static final int MAX_FAIL_RETRY = 2;

    /**
     * Default chrome language during initial start
     * use double language from ISO-639
     */
    public static final String CHROME_LANGUAGE = "en";

    public static final String PLATFORM_AND_BROWSER = "win_chrome";

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
