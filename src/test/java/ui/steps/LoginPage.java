package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.LoginElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends LoginElements {

    public LoginPage openLoginPage() {
        open("");
        return new LoginPage();
    }


    public MainPage loginByUser(String username, String password) {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().sendKeys(password);
        submitButton().click();
        return new MainPage();
    }

    public LoginPage errorOnLogin(){
        errorMessage().shouldBe(visible);
        return this;
    }
}