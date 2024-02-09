package ru.ibs.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.framework.pages.MainPage;

public class CartTest extends BaseTests {



    MainPage mainPage =  new MainPage(driver);



    @Test
    public void cartTest() {

        mainPage.findProduct();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }






}
