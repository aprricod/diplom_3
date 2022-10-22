package ru.yandex.praktikum.stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class LoginPage extends BasePage {

    // заголовок вход
    @FindBy(how = How.XPATH, using = "//div[@class='Auth_login__3hAey']/h2")
    private SelenideElement loginPageTitle;

    // кнопка вход
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement loginPageButton;

    // кнопка восстановить пароль
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPassButton;


    public void checkRecoveryPassButton() {
        recoveryPassButton.shouldBe(Condition.visible);
    }
}
