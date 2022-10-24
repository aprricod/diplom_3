package ru.yandex.praktikum.stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {

    // кнопка личный кабинет
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;

    // кнопка войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterToAccountButton;

    // кнопка оформить заказ
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement createOrder;

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickEnterToAccountButton() {
        enterToAccountButton.click();
    }

    public void checkCreateOrderButton(){
        createOrder.shouldBe(Condition.visible);
    }

}
