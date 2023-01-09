package com.yandex.diplom3;

import org.junit.Test;
import com.codeborne.selenide.Condition;
import com.yandex.diplom3.PageObjects.MainPage;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;
import org.junit.After;

public class NavigationTest {
    private MainPage mainPage = new MainPage();

    @After
    public void logOut(){
        closeWebDriver();
    }

    @Test
    public void navigationToAppHeaderPageTest(){
        open("https://stellarburgers.nomoreparties.site");
        $(mainPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(mainPage.getProfile()).click();
        $(mainPage.getEnter()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void navigationToMainPageTest(){
        open("https://stellarburgers.nomoreparties.site/login");
        $(mainPage.getEnter()).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(mainPage.getAppHeader()).click();
        $(mainPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
