package ru.ibs.framework.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {


    @FindBy(xpath = "//span[contains(text(),'Я согласен')]")
    WebElement cookiesButton;

    @Step("Закрытие сообщение cookies")
    public HomePage closeCookiesButton() {
        cookiesButton.click();
        addScreenshot();
        return this;
    }



    @Step("Поиск продоктов с названием {text}")
    public SearchPage searchProduct (String text) {
        searchField.click();
        searchField.sendKeys(text);
        searchField.submit();
        addScreenshot();
        return pageManager.getSearchPage();
    }









}
