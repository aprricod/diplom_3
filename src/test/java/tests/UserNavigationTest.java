package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.stellar.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class UserLoginTest {

    static String baseURL = "https://stellarburgers.nomoreparties.site/";
    static String profileURL = "https://stellarburgers.nomoreparties.site/account/profile";
    static String loginURL = "https://stellarburgers.nomoreparties.site/login";

    String userEmail = "stellar.test1@yopmail.com";
    String userPassword = "123456";

    @Before
    @Step("before")
    public void setProperties() {
        MainPage mainPage = open(baseURL, MainPage.class);
    }

    // вход через кнопку «Личный кабинет»,
    @Test
    public void loginWithAccountButtonTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        mainPage.clickAccountButton();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    // вход по кнопке «Войти в аккаунт» на главной,
    @Test
    public void loginWithEnterToAccountButtonTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        mainPage.clickEnterToAccountButton();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    // вход через кнопку в форме регистрации
    @Test
    public void loginWithEnterToAccountButtonOnRegFormTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        RegisterPage registerPage = page(RegisterPage.class);
        mainPage.clickEnterToAccountButton();
        loginPage.clickRegistrationPageLink();
        registerPage.clickLoginPageLink();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    // вход через кнопку в форме восстановления пароля
    @Test
    public void loginWithEnterToAccountButtonOnResetPasswordFormTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        PasswordRestorePage passwordRestorePage = page(PasswordRestorePage.class);
        mainPage.clickEnterToAccountButton();
        loginPage.clickRecoveryPassButton();
        passwordRestorePage.clickLoginPageLink();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    // Переход в личный кабинет
    @Test
    public void openUserAccountTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        AccountPage accountPage = page(AccountPage.class);
        mainPage.clickAccountButton();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountPage.checkIfInputVisible();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(profileURL, currentUrl);
    }

    // Переход из личного кабинета в конструктор
    @Test
    public void navigateToConstructorFromUserAccountTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        AccountPage accountPage = page(AccountPage.class);
        mainPage.clickAccountButton();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountPage.clickConstructorLink();
        mainPage.checkCreateOrderButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(baseURL, currentUrl);
    }

    // Переход из личного кабинета в конструктор по клику на логотип
    @Test
    public void navigateToConstructorFromUserAccountByClickOnLogoTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        AccountPage accountPage = page(AccountPage.class);
        mainPage.clickAccountButton();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountPage.clickStellarLogo();
        mainPage.checkCreateOrderButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(baseURL, currentUrl);
    }

    // выход через кнопку «Выход»,
    @Test
    public void logoutFromAccountTest() {
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);
        AccountPage accountPage = page(AccountPage.class);
        mainPage.clickAccountButton();
        loginPage.setUserData(userEmail, userPassword);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        accountPage.clickExitButton();
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
