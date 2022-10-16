package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.praktikum.stellar.MainPage;
import ru.yandex.praktikum.stellar.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class UserRegistrationTest {

    static String baseURL = "https://stellarburgers.nomoreparties.site/";
    static String loginURL = "https://stellarburgers.nomoreparties.site/login";


    @BeforeClass
    public static void setProperties() {
        MainPage mainPage =

                open(baseURL, MainPage.class);
    }

    @Test
    public void checkPasswordLengthErrorTest() {
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegistrationPageLink();
        registerPage.setName("тест1");
        registerPage.setEmail("stellar.test1@yopmail.com");
        registerPage.setPassword("12345");
        registerPage.clickRegistrationButton();
        registerPage.checkPasswordErrorMsgDisplayed();
    }

    @Test
    public void createNewUserTest() throws InterruptedException {
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegistrationPageLink();
        registerPage.setName("тест7");
        registerPage.setEmail("stellar.test7@yopmail.com");
        registerPage.setPassword("123456");
        registerPage.clickRegistrationButton();
        Thread.sleep(3000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(loginURL, currentUrl);
    }

    @AfterClass
    public static void closeDriver() {
        closeWebDriver();
    }
}
