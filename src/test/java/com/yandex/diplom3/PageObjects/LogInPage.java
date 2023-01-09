package com.yandex.diplom3.PageObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;

public class LogInPage {
    private By logInLink = byText("Войти в аккаунт");
    private By assembleABurger = byText("Соберите бургер");
    private By profile = byText("Личный Кабинет");
    private By enter = byText("Войти");

    public By getLogInLink() {
        return logInLink;
    }
    public By getAssembleABurger() {
        return assembleABurger;
    }
    public By getProfile() {
        return profile;
    }
    public By getEnter() {
        return enter;
    }
}
