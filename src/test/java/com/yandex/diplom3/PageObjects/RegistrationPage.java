package com.yandex.diplom3.PageObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;

public class RegistrationPage {
    private By enter = byText("Вход");
    private By incorrectPassword = byText("Некорректный пароль");
    private By theSameUserAlreadyExist = byText("Такой пользователь уже существует");

    public By getEnter() {
        return enter;
    }
    public By getIncorrectPassword() {
        return incorrectPassword;
    }
    public By getTheSameUserAlreadyExist() {
        return theSameUserAlreadyExist;
    }


}
