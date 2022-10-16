package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.praktikum.stellar.MainPage;
import ru.yandex.praktikum.stellar.RegisterPage;

import static com.codeborne.selenide.Selenide.*;

public class WrongPasswordTest {
    @BeforeClass
    public static void setProperties() {
        MainPage mainPage =

                open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @Test
    public void checkPasswordLengthError() {
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginButton();
        registerPage.clickRegisterButton();
        registerPage.setName("тест4");
        registerPage.setEmail("stellar.test4@yopmail.com");
        registerPage.setPassword("12345");
        registerPage.checkPasswordErrorMsg();
    }

    @AfterClass
    public static void closeDriver() {
        closeWebDriver();
    }
}
