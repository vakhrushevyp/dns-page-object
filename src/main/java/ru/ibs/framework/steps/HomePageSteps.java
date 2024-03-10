package ru.ibs.framework.steps;

import io.cucumber.java.en.And;

public class HomePageSteps extends BasePageSteps {


    @And("^Закрытие сообщение cookies$")
    public void closeCookiesButton() {
       pageManager.getHomePage().closeCookiesButton();
    }

    @And("^Поиск продуктов с названием \"(.+)\"$")
    public void searchProduct(String text) {
        pageManager.getHomePage().searchProduct(text);
    }

}
