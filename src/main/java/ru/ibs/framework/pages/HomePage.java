package ru.ibs.framework.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    @FindBy(xpath = "//span[contains(text(),'Я согласен')]")
    WebElement cookiesButton;


    public HomePage closeCookiesButton() {
        cookiesButton.click();
        addScreenshot();
        return this;
    }


    public SearchPage searchProduct(String text) {
        searchField.click();
        searchField.sendKeys(text);
        searchField.submit();
        addScreenshot();
        return pageManager.getSearchPage();
    }


}
