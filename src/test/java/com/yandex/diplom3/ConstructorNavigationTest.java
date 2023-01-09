package com.yandex.diplom3;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;
import org.junit.Test;
import org.openqa.selenium.By;

public class ConstructorNavigationTest {

    @Test
    public void navigationToAppHeaderPageTest(){
        open("https://stellarburgers.nomoreparties.site");
        $(By.xpath("//span[text() = 'Начинки']/parent::*")).click();
        $(byText("Сыр с астероидной плесенью")).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(By.xpath("//span[text() = 'Соусы']/parent::*")).click();
        $(byText("Соус Spicy-X")).shouldBe(Condition.visible, Duration.ofSeconds(1));
        $(By.xpath("//span[text() = 'Булки']/parent::*")).click();
        $(byText("Флюоресцентная булка R2-D3")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
