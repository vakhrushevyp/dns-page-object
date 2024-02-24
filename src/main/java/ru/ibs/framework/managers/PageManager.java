package ru.ibs.framework.managers;


import ru.ibs.framework.pages.BasketPage;
import ru.ibs.framework.pages.HomePage;
import ru.ibs.framework.pages.ProductPage;
import ru.ibs.framework.pages.SearchPage;

public class PageManager {


    private HomePage homePage;

    private SearchPage searchPage;

    private ProductPage productPage;

    private BasketPage basketPage;


    private static PageManager INSTANCE = null;

    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public BasketPage getBasketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }


}
