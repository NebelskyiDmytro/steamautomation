package common;

import pages.base.BasePage;

public class Config {

    public static final String PLATFORM_AND_BROWSER = "win_chrome";

    /**
     * Clear browser cookies and local storage after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    /**
     * To keep the browser open after suite
     * if true - browser close
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

}
