package ru.ibs.framework.steps;

import io.cucumber.java.en.And;

public class SearchPageSteps extends BasePageSteps {


    @And("^Выбор продукта с названием \"(.+)\"$")
    public void selectProductByText(String text) {
        pageManager.getSearchPage().selectProductByText(text);
    }

}
