package com.yandex.diplom3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.Condition;
import com.yandex.diplom3.PageObjects.LogInPage;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

public class LogInTest {
    private Steps steps = new Steps();
    private TestData testData;
    private LogInPage logInPage = new LogInPage();

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
        $(logInPage.getLogInLink()).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(logInPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInFromAppHeaderButtonTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site");
        $(logInPage.getProfile()).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(logInPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInAfterRegistrationTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(logInPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInByButtonOnRegistrationPageTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site/register");
        $(logInPage.getEnter()).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(logInPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void logInByButtonOnForgotPasswordPageTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open("https://stellarburgers.nomoreparties.site/forgot-password");
        $(logInPage.getEnter()).click();
        steps.fillUpLogInForm(testData.getMail(),testData.getPassword());
        $(logInPage.getAssembleABurger()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
