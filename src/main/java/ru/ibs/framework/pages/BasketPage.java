package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    int totalPrice;

    @FindBy(xpath = "//div[@data-meta-name='AdditionalService']/button/span/span/span")
    List<WebElement> serviceItemText;

    List<WebElement> serviceItemYear;

    @FindBy(xpath = "//div[@data-meta-name='BasketSummary']//span[@data-meta-price]/span[@color]")
    WebElement totalPriceText;
    

    public void addServiceItem(String text) {
        for (WebElement item: serviceItemText ) {
            if (item.getText().contains(text)) {
                item.findElement(By.xpath("../../../../..//input")).click();
                serviceItemYear = item.findElements(By.xpath("../../../..//label"));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return;
            }

        }

    }


    public void setServiceItemYear(String text) {

        for (WebElement item: serviceItemYear ) {
            System.out.println(item.getDomAttribute("data-meta-value").contains(text));
            if (item.getDomAttribute("data-meta-value").contains(text)) {
                item.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return;
            }

        }
    }

    public void saveTotalPriceAndBuy() {
        totalPrice = Integer.parseInt(totalPriceText.getText().replaceAll(" ", ""));

    }






}
