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

    // раздел булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunSwitcher;

    // раздел булки
    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement titleBun;

    // раздел соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement sauceSwitcher;

    // заголовок соусы
    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement titleSauce;

    // раздел начинки
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement fillingSwitcher;

    // заголовок начинки
    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement titleFilling;

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickEnterToAccountButton() {
        enterToAccountButton.click();
    }

    public void checkCreateOrderButton() {
        createOrder.shouldBe(Condition.visible);
    }

    public void clickBunSwitcher() {
        bunSwitcher.click();
    }

    public void clickSauceSwitcher() {
        sauceSwitcher.click();
    }

    public void clickFillingSwitcher() {
        fillingSwitcher.click();
    }

    public SelenideElement bunPosition() {
        return titleBun;
    }

    public SelenideElement saucePosition() {
        return titleSauce;
    }

    public SelenideElement fillingPosition() {
        return titleFilling;
    }
}
