package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.praktikum.stellar.MainPage;
import ru.yandex.praktikum.stellar.RegisterPage;

import static com.codeborne.selenide.Selenide.*;

public class UserRegistrationTest {
    @BeforeClass
    public static void setProperties() {
        MainPage mainPage =

                open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @Test
    public void checkPasswordLengthErrorTest() {
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegistrationPageLink();
        registerPage.setName("тест4");
        registerPage.setEmail("stellar.test4@yopmail.com");
        registerPage.setPassword("12345");
        registerPage.clickRegistrationButton();
        registerPage.checkPasswordErrorMsg();
    }

    @Test
    public void createNewUserTest() throws InterruptedException {
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegistrationPageLink();
        registerPage.setName("тест4");
        registerPage.setEmail("stellar.test4@yopmail.com");
        registerPage.setPassword("123456");
        registerPage.clickRegistrationButton();
        MainPage mainPage = page(MainPage.class);
        Thread.sleep(3000);
        mainPage.checkLoginPageTitle();
        Thread.sleep(3000);
    }

    @AfterClass
    public static void closeDriver() {
        closeWebDriver();
    }
}
