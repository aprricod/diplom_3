package ru.yandex.praktikum.stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    // заголовок вход
    @FindBy(how = How.XPATH, using = "//div[@class='Auth_login__3hAey']/h2")
    private SelenideElement loginPageTitle;

    // поле ввода почты
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement emailInput;

    // поле ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordInput;

    // кнопка вход
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement loginButton;

    // линк для перехода на страницу регистрации
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement registrationPageLink;

    // кнопка восстановить пароль
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPassButton;

    public void setUserData(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void checkRecoveryPassButton() {
        recoveryPassButton.shouldBe(Condition.visible);
    }

    public void clickRegistrationPageLink() {
        registrationPageLink.click();
    }

    public void clickRecoveryPassButton(){
        recoveryPassButton.click();
    }
}
