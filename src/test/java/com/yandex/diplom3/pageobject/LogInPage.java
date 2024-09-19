package com.yandex.diplom3.pageobject;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import java.time.Duration;

public class LogInPage extends CommonPage {

    public LogInPage fillUpLogInForm(String mail, String password){
        $(entrance).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(emailField).sibling(0).setValue(mail);
        $(passwordField).sibling(0).setValue(password);
        $(enter).click();
        return this;
    }

    public LogInPage logInButtonClick(){
        $(logInLink).click();
        return this;
    }

    public LogInPage enterButtonClick(){
        $(enter).click();
        return this;
    }

    public LogInPage profileButtonClick(){
        $(profile).click();
        return this;
    }

    public LogInPage checkAssembleABurger(){
        $(assembleABurger).shouldBe(Condition.visible, Duration.ofSeconds(1));
        return this;
    }
}
