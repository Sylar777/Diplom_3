package com.yandex.diplom3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

public class RegistrationTest {
    Steps steps = new Steps();
    TestData testData;

    @Before
    public void setup(){
        testData = new TestData();
    }

    @After
    public void logOut(){
        closeWebDriver();
    }

    @Test
    public void registrationSuccessPassTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        $(byText("Вход")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void registrationValidationTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),"14243");
        $(byText("Некорректный пароль")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void registrationDuplicateValidationTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        $(byText("Такой пользователь уже существует")).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
