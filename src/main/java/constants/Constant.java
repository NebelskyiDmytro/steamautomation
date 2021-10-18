package constants;

public class Constant {

    public static class TimeoutVariables {
        public static final int THREAD_SLEEP = 2;
        public static final int IMPLICIT_WAIT = 10;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Urls {
        public static final String STEAM_WELCOME_URL = "https://store.steampowered.com/";
        public static final String STEAM_WELCOME_TITLE_EN = "Welcome to Steam";
        public static final String STEAM_WELCOME_TITLE_RU = "Добро пожаловать в Steam";
        public static final String STEAM_WELCOME_TITLE_UA = "Вітаємо у Steam";
        public static final String SIGN_IN_URL = "https://store.steampowered.com/login/";
        public static final String SIGN_IN_TITLE_EN = "Sign In";
        public static final String SIGN_IN_TITLE_RU = "Войти";
        public static final String SIGN_IN_TITLE_UA = "Увійти";
        //TODO Create title verification
        public static final String EDIT_PROFILE_TITLE_EN = "Steam Community :: Edit Profile";
    }

    public static class Users {
        public static final String USER1_LOGIN = "kahramanakyil";
        public static final String USER1_PASS = "Nebelskyi2021";
        public static final String USER2_LOGIN = "hilli477";
        public static final String USER2_PASS = "Nebelskyi2021";
    }

    public static class ErrorMessages {
        public static final String LOGIN_ERROR = "The account name or password that you have entered is incorrect.";
    }

    public static class LoggerMessages {
        public static final String CAPTCHA_SKIP_MESSAGE = "Test execution is skipped. Captcha is displayed.";
    }

}
