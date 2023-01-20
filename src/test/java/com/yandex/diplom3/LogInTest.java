package com.yandex.diplom3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.yandex.diplom3.pageobject.*;
import static com.codeborne.selenide.Selenide.*;

public class LogInTest {
    private TestData testData;
    private LogInPage logInPage = new LogInPage();
    private MainPage mainPage = new MainPage();
    private RegistrationPage registrationPage = new RegistrationPage();
    DeleteUserStep deleteUserStep;

    @Before
    public void setup(){
        testData = new TestData();
        deleteUserStep = new DeleteUserStep();
    }

    @After
    public void logOut(){
        mainPage.logOut();
        closeWebDriver();
        deleteUserStep.deleteUser(testData.getMail(),testData.getPassword());
    }

    @Test
    public void logInFromMainPageTest(){
        registrationPage.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open(Urls.MAIN);
        logInPage
            .logInButtonClick()
            .fillUpLogInForm(testData.getMail(),testData.getPassword())
            .checkAssembleABurger();
    }

    @Test
    public void logInFromAppHeaderButtonTest(){
        registrationPage.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open(Urls.MAIN);
        logInPage
            .profileButtonClick()
            .fillUpLogInForm(testData.getMail(),testData.getPassword())
            .checkAssembleABurger();
    }

    @Test
    public void logInAfterRegistrationTest(){
        registrationPage.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        logInPage
            .fillUpLogInForm(testData.getMail(),testData.getPassword())
            .checkAssembleABurger();
    }

    @Test
    public void logInByButtonOnRegistrationPageTest(){
        registrationPage.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open(Urls.REGISTRATION);
        logInPage
            .enterButtonClick()
            .fillUpLogInForm(testData.getMail(),testData.getPassword())
            .checkAssembleABurger();
    }

    @Test
    public void logInByButtonOnForgotPasswordPageTest(){
        registrationPage.fillUpRegistrationForm(testData.getName(),testData.getMail(),testData.getPassword());
        open(Urls.FORGOT_PASSWORD);
        logInPage
            .enterButtonClick()
            .fillUpLogInForm(testData.getMail(),testData.getPassword())
            .checkAssembleABurger();
    }
}
