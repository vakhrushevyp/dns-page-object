package ru.ibs.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.framework.pages.BasketPage;
import ru.ibs.framework.pages.HomePage;
import ru.ibs.framework.pages.ProductPage;
import ru.ibs.framework.pages.SearchPage;
import ru.ibs.tests.base.BaseTests;

public class CartTest extends BaseTests {



    HomePage homePage = new HomePage(driverManager.getDriver());
    SearchPage searchPage = new SearchPage(driverManager.getDriver());

    ProductPage productPage = new ProductPage(driverManager.getDriver());

    BasketPage basketPage = new BasketPage(driverManager.getDriver());



    @Test
    public void cartTest() {

    homePage.searchProduct("playstation");
    searchPage.selectProductByText("PlayStation 5 Slim");
    productPage.addToBasket();
    basketPage.addServiceItem("Продления гарантии");
    basketPage.setServiceItemYear("+2 года");
    basketPage.searchProduct("телевизор xiaomi");
    searchPage.selectProductByText("50\" Телевизор Xiaomi Mi TV A2, 4K Ultra HD");
    productPage.addToBasket();
    basketPage.checkTotalPrice();
    basketPage.checkServiceItemYear("PlayStation 5 Slim","+2 года");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }






}
