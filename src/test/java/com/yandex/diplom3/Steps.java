package com.yandex.diplom3;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import java.time.Duration;

public class Steps {

    @Step
    public void fillUpRegistrationForm(String name, String mail, String password){
        open("https://stellarburgers.nomoreparties.site/register");
        $(byText("Имя")).sibling(0).setValue(name);
        $(byText("Email")).sibling(0).setValue(mail);
        $(byText("Пароль")).sibling(0).setValue(password);
        $(byText("Зарегистрироваться")).click();
    }

    @Step
    public void fillUpLogInForm(String mail, String password){
        $(byText("Вход")).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(byText("Email")).sibling(0).setValue(mail);
        $(byText("Пароль")).sibling(0).setValue(password);
        $(byText("Войти")).click();
    }

    @Step
    public void logOut(){
        $(byText("Личный Кабинет")).click();
        $(byText("Выход")).shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
    }
}
