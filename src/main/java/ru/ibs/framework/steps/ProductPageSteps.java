package ru.ibs.framework.steps;

import io.cucumber.java.en.And;

public class ProductPageSteps extends BasePageSteps {

    @And("^Добавляем продукт в корзину$")
    public void addToBasket(){
        pageManager.getProductPage().addToBasket();
    }

}
