package tests;

import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.stellar.LoginPage;
import ru.yandex.praktikum.stellar.MainPage;
import ru.yandex.praktikum.stellar.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class UserLoginTest {

    static String baseURL = "https://stellarburgers.nomoreparties.site/";
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

}
