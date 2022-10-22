package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.stellar.LoginPage;
import ru.yandex.praktikum.stellar.MainPage;
import ru.yandex.praktikum.stellar.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class UserRegistrationTest {

    static String baseURL = "https://stellarburgers.nomoreparties.site/";
    static String loginURL = "https://stellarburgers.nomoreparties.site/login";

    String userName = RandomStringUtils.randomAlphabetic(6);
    String userEmail = RandomStringUtils.randomAlphanumeric(10) + "@mail.com";
    String userPassword = RandomStringUtils.randomAlphabetic(6);

    @Before
    @Step("before")
    public void setProperties() {
        MainPage mainPage = open(baseURL, MainPage.class);
    }

    @Test
    @DisplayName("Check incorrect password notification")
    @Description("Check if incorrect password notification is appeared in case of short password")
    public void checkPasswordLengthErrorTest() {
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegistrationPageLink();
        registerPage.setUserData("тест1", "stellar.test1@yopmail.com", "12345");
        registerPage.clickRegistrationButton();
        registerPage.checkPasswordErrorMsgDisplayed();
    }

    @Test
    @DisplayName("Create new user")
    @Description("Create new user with correct user data")
    @Step("Create user")
    public void createNewUserTest() {
        LoginPage loginPage = page(LoginPage.class);
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegistrationPageLink();
        registerPage.setUserData(userName, userEmail, userPassword);
        registerPage.clickRegistrationButton();
        loginPage.checkRecoveryPassButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(loginURL, currentUrl);
    }

    @AfterClass
    @Step("after")
    public static void closeDriver() {
        closeWebDriver();
    }
}
