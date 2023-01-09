package com.yandex.diplom3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

public class LogInTest {
    Steps steps = new Steps();
    TestData testData;

    @Before
    public void setup(){
        testData = new TestData();
    }

    @After
    public void logOut(){
        steps.logOut();
        closeWebDriver();
    }

    @Test
    public void logInFromMainPageTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site");
        $(byText("Войти в аккаунт")).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInFromAppHeaderButtonTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site");
        $(byText("Личный Кабинет")).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInAfterRegistrationTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInByButtonOnRegistrationPageTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site/register");
        $(byText("Войти")).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInByButtonOnForgotPasswordPageTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site/forgot-password");
        $(byText("Войти")).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(byText("Соберите бургер")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
