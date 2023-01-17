package com.yandex.diplom3;

import org.junit.Test;
import com.yandex.diplom3.pageobject.*;
import static com.codeborne.selenide.Selenide.*;
import org.junit.After;

public class NavigationTest {
    private LogInPage logInPage = new LogInPage();
    private RegistrationPage registrationPage = new RegistrationPage();

    @After
    public void logOut(){
        closeWebDriver();
    }

    @Test
    public void navigationToAppHeaderPageTest(){
        open(Urls.MAIN);
        logInPage
            .checkAssembleABurger()
            .profileButtonClick();
        registrationPage.checkRegistrationSuccess();
    }

    @Test
    public void navigationToMainPageTest(){
        open(Urls.LOGIN);
        logInPage
            .enterButtonClick()
            .appHeaderButtonClick();
        logInPage.checkAssembleABurger();
    }
}
