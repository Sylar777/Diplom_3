package com.yandex.diplom3.PageObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;

public class MainPage {
    private By assembleABurger = byText("Соберите бургер");
    private By profile = byText("Личный Кабинет");
    private By enter = byText("Войти");
    private By appHeader = byClassName("AppHeader_header__logo__2D0X2");
    public By getAssembleABurger() {
        return assembleABurger;
    }
    public By getProfile() {
        return profile;
    }
    public By getEnter() {
        return enter;
    }
    public By getAppHeader() {
        return appHeader;
    }

}
