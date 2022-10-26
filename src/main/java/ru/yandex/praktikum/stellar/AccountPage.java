package ru.yandex.praktikum.stellar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends BasePage{
    // инпут имя
    @FindBy(how = How.XPATH, using = "//input[@name='Name']")
    private SelenideElement nameInput;

    // линк конструктор
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorLink;

    // лого стеллар
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement stellarLogo;

    public void checkIfInputVisible(){
        nameInput.shouldBe(Condition.visible);
    }

    public void clickConstructorLink(){
        constructorLink.click();
    }

    public void clickStellarLogo(){
        stellarLogo.click();
    }
}
