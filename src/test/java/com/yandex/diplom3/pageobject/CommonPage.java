package com.yandex.diplom3.pageobject;

import org.openqa.selenium.By;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CommonPage {
    protected By logInLink = byText("Войти в аккаунт");
    protected By enter = byText("Войти");
    protected By entrance = byText("Вход");
    protected By assembleABurger = byText("Соберите бургер");
    protected By profile = byText("Личный Кабинет");
    protected By appHeader = byClassName("AppHeader_header__logo__2D0X2");
    protected By ingredientList = byClassName("BurgerIngredients_ingredients__menuContainer__Xu3Mo");
    protected By exit = byText("Выход");
    protected By incorrectPassword = byText("Некорректный пароль");
    protected By theSameUserAlreadyExist = byText("Такой пользователь уже существует");
    protected By nameField = byText("Имя");
    protected By emailField = byText("Email");
    protected By passwordField = byText("Пароль");
    protected By registration = byText("Зарегистрироваться");
    protected ElementsCollection listOfTabs = $$(byClassName("tab_tab__1SPyG"));

    public CommonPage appHeaderButtonClick(){
        $(appHeader).click();
        return this;
    }

    public By getIngredientTypeButton(String nameOfIngredientType){
        return By.xpath(".//span[contains(@class, 'text') and (text()='" + nameOfIngredientType + "')]");
    }

    public By getIngredientTypeTab(String nameOfIngredientType){
        return By.xpath(".//span[contains(@class, 'text') and (text()='" + nameOfIngredientType + "')]/parent::*");
    }
}
