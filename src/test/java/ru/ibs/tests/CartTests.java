package ru.ibs.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.tests.base.BaseTests;

public class CartTests extends BaseTests {

    @Test
    public void cartTest() {

        pageManager.getHomePage().closeCookiesButton()
                .searchProduct("playstation")
                .selectProductByText("PlayStation 5 Slim")
                .addToBasket()
                .addServiceItem("Продления гарантии")
                .setServiceItemYear("+2 года")
                .searchProduct("телевизор xiaomi")
                .selectProductByText("50\" Телевизор Xiaomi Mi TV A2, 4K Ultra HD")
                .addToBasket()
                .checkTotalPrice()
                .checkServiceItemYear("PlayStation 5 Slim", "+2 года");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
