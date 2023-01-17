package com.yandex.diplom3.pageobject;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import java.time.Duration;

public class RegistrationPage extends CommonPage {

    public RegistrationPage fillUpRegistrationForm(String name, String mail, String password){
        open("https://stellarburgers.nomoreparties.site/register");
        $(nameField).sibling(0).setValue(name);
        $(emailField).sibling(0).setValue(mail);
        $(passwordField).sibling(0).setValue(password);
        $(registration).click();
        return this;
    }

    public RegistrationPage checkRegistrationSuccess(){
        $(enter).shouldBe(Condition.visible, Duration.ofSeconds(1));
        return this;
    }

    public RegistrationPage checkIncorrectPasswordInsert(){
        $(incorrectPassword).shouldBe(Condition.visible, Duration.ofSeconds(1));
        return this;
    }

    public RegistrationPage checkTheSameUserAlreadyExist(){
        $(theSameUserAlreadyExist).shouldBe(Condition.visible, Duration.ofSeconds(1));
        return this;
    }
}
