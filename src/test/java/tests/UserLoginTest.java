package tests;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.stellar.MainPage;

import static com.codeborne.selenide.Selenide.open;

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

    @Test
    public void logByAccountButtonTest(){

    }

    @Test
    public void logByEnterToAccountButtonTest(){

    }
}
