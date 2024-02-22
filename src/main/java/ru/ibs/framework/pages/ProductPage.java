package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.Data.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@data-meta-name='PriceBlock__price']/span/span/span[@color]")
    WebElement productPrice;

    @FindBy(xpath = "//button[@data-meta-name='BasketDesktopButton']")
    WebElement basketButton;

    @FindBy(xpath = "//button/span[contains(text(),'Перейти в корзину')]")
    WebElement getBasketButton;





    public void addToBasket() {
        products.get(currentProductId).setCost(Integer.parseInt(productPrice.getText().replaceAll(" ", "")));
        basketButton.click();

        try {
            getBasketButton.click();
        } catch (TimeoutException ignore) {

        }


    }
    






}
