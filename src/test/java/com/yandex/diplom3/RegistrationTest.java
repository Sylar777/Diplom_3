package com.yandex.diplom3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.Condition;
import com.yandex.diplom3.PageObjects.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

public class RegistrationTest {
    private Steps steps = new Steps();
    private TestData testData;
    private RegistrationPage registrationPage = new RegistrationPage();

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
        $(registrationPage.getEnter()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void registrationValidationTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),"14243");
        $(registrationPage.getIncorrectPassword()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }

    @Test
    public void registrationDuplicateValidationTest(){
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        steps.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        $(registrationPage.getTheSameUserAlreadyExist()).shouldBe(Condition.visible, Duration.ofSeconds(1));
    }
}
