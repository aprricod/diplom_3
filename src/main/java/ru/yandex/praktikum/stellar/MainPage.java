package ru.yandex.praktikum.stellar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {

    // заголовок вход
    @FindBy(how = How.XPATH, using = "//div[@class='Auth_login__3hAey']/h2")
    private SelenideElement loginPageTitle;

}
