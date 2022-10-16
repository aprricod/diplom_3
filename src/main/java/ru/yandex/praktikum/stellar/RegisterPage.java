package ru.yandex.praktikum.stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {

    // кнопка войти в аккаунт
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement loginButton;

    // линк для перехода на страницу регистрации
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement registrationPageLink;

    // поле ввода имени
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input[@name='name']")
    private SelenideElement nameInput;

    // поле ввода почты
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement emailInput;

    // поле ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordInput;

    // зарегистрироваться
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registrationButton;

    // сообщение об ошибке для пароля
    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement passwordErrorMsg;


    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickRegistrationPageLink() {
        registrationPageLink.click();
    }

    public void setName(String name) {
        nameInput.setValue(name);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void checkPasswordErrorMsgDisplayed() {
        passwordErrorMsg.shouldHave(Condition.exactText("Некорректный пароль"));
    }
}
