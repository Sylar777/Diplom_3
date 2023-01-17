package com.yandex.diplom3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.yandex.diplom3.pageobject.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
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
        registrationPage
            .fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword())
            .checkRegistrationSuccess();
    }

    @Test
    public void registrationValidationTest(){
        registrationPage
            .fillUpRegistrationForm(testData.getName(),testData.getMail(),"14243")
            .checkIncorrectPasswordInsert();
    }

    @Test
    public void registrationDuplicateValidationTest(){
        registrationPage
            .fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword())
            .fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword())
            .checkTheSameUserAlreadyExist();
    }
}
