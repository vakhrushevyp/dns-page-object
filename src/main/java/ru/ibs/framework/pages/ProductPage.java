package ru.ibs.framework.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {


    @FindBy(xpath = "//div[@data-meta-name='PriceBlock__price']/span/span/span[@color]")
    WebElement productPrice;

    @FindBy(xpath = "//button[@data-meta-name='BasketDesktopButton']")
    WebElement basketButton;

    @FindBy(xpath = "//button/span[contains(text(),'Перейти в корзину')]")
    WebElement getBasketButton;


    public BasketPage addToBasket() {
        products.get(currentProductId).setCost(Integer.parseInt(productPrice.getText().replaceAll(" ", "")));
        basketButton.click();
        addScreenshot();

        try {
            getBasketButton.click();
            addScreenshot();
        } catch (TimeoutException ignore) {

        }

        return pageManager.getBasketPage();
    }


}
