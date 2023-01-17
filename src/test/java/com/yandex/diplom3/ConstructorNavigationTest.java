package com.yandex.diplom3;

import com.yandex.diplom3.pageobject.MainPage;
import org.junit.Before;
import static com.codeborne.selenide.Selenide.*;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ConstructorNavigationTest {
    MainPage mainPage;
    String nameOfIngredientType;

    public ConstructorNavigationTest(String nameOfIngredientType) {
        this.nameOfIngredientType = nameOfIngredientType;
    }

    @Before
    public void setup(){
        mainPage = new MainPage();
    }

    @Parameterized.Parameters(name = "Название типа ингредиента: {0}")
    public static Object[][] getCities() {
        return new Object[][] {
                { "Соусы" },
                { "Начинки" }
        };
    }

    @Test
    public void constructorScrollNavigationTest(){
        open(Urls.MAIN);
        mainPage
            .ingredientsButtonClick(nameOfIngredientType)
            .checkStateOfTabs(nameOfIngredientType);
    }
}
