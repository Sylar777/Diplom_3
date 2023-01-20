package com.yandex.diplom3.pageobject;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Condition.attribute;

public class MainPage extends CommonPage{

    public void logOut(){
        $(profile).click();
        $(exit).shouldBe(Condition.visible, Duration.ofSeconds(1)).click();
    }

    public MainPage waitPageLoading(){
        $(logInLink).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public MainPage ingredientsButtonClick(String nameOfIngredientType){
        $(getIngredientTypeButton(nameOfIngredientType)).click();
        $(getIngredientTypeTab(nameOfIngredientType))
        .shouldBe(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"), Duration.ofSeconds(3));
        return this;
    }

    public void checkStateOfTabs(String nameOfIngredientType){
        $(getIngredientTypeTab(nameOfIngredientType))
        .shouldHave(attribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }
}
