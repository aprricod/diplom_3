package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import ru.yandex.praktikum.stellar.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserNavigationTest {

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
    @DisplayName("Login test")
    @Description("Login with account button")
    @Step("Login")
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
    @DisplayName("Login test")
    @Description("Login with login button")
    @Step("Login")
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
    @DisplayName("Login test")
    @Description("Login on registration form")
    @Step("Login")
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
    @DisplayName("Login test")
    @Description("Login on password restore form")
    @Step("Login")
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
    @DisplayName("Navigation to user account")
    @Description("Navigation to user account test")
    @Step("Navigation to account")
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
    @DisplayName("Navigation to constructor")
    @Description("Navigation from user account to constructor test")
    @Step("Navigation")
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
    @DisplayName("Navigation to constructor")
    @Description("Navigation from user account to constructor test by clicking logo")
    @Step("Navigation")
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
    @DisplayName("Logout from account")
    @Description("Logout from account test")
    @Step("Logout")
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

    // проверка скролла
    @Test
    @DisplayName("Scroll test")
    @Description("Scroll to subsection test")
    @Step("Scroll")
    public void subsectionScrollTest() {
        MainPage mainPage = page(MainPage.class);

        Point firstSaucePosition = mainPage.saucePosition().getLocation();
        mainPage.clickSauceSwitcher();
        mainPage.saucePosition().shouldBe(Condition.visible);
        Point secondSaucePosition = mainPage.saucePosition().getLocation();

        Point firstFillingPosition = mainPage.fillingPosition().getLocation();
        mainPage.clickFillingSwitcher();
        mainPage.fillingPosition().shouldBe(Condition.visible);
        Point secondFillingPosition = mainPage.fillingPosition().getLocation();

        Point firstBunPosition = mainPage.bunPosition().getLocation();
        mainPage.clickBunSwitcher();
        mainPage.bunPosition().shouldBe(Condition.visible);
        Point secondBunPosition = mainPage.bunPosition().getLocation();

        assertNotEquals(firstSaucePosition, secondSaucePosition);
        assertNotEquals(firstFillingPosition, secondFillingPosition);
        assertNotEquals(firstBunPosition, secondBunPosition);
    }

    @After
    @Step("after")
    public void closeDriver() {
        closeWebDriver();
    }
}
