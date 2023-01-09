package com.yandex.diplom3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;
import org.junit.Test;

public class ConstructorNavigationTest {

    @Test
    public void navigationToAppHeaderPageTest(){
        open("https://stellarburgers.nomoreparties.site");
        $(byText("Сыр с астероидной плесенью")).shouldBe(Condition.visible, Duration.ofSeconds(1));

        // $(byText("Начинки")).parent().click();
        Selenide.Wait().withTimeout(Duration.ofSeconds(30));
        $(byText("Сыр с астероидной плесенью")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
