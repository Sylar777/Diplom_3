package com.yandex.diplom3;

import org.junit.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;
import org.junit.After;

public class NavigationTest {
    Steps steps = new Steps();

    @After
    public void logOut(){
        closeWebDriver();
    }

    @Test
    public void navigationToAppHeaderPageTest(){
        open("https://stellarburgers.nomoreparties.site");
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(byText("Личный Кабинет")).click();
        $(byText("Вход")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void navigationToMainPageTest(){
        open("https://stellarburgers.nomoreparties.site/login");
        $(byText("Вход")).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(byClassName("AppHeader_header__logo__2D0X2")).click();
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
