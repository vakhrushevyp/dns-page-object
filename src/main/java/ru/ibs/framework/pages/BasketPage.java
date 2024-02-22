package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.Data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    int totalPrice;


    String productXpath = "//div[@data-meta-name='BasketSnippet' and @data-meta-id='%d']";

    List<WebElement> serviceItemText;


    @FindBy(xpath = "//div[@data-meta-name='AdditionalService']/button/span/span/span")
    List<WebElement> serviceItemYear;

    @FindBy(xpath = "//div[@data-meta-name='BasketSummary']//span[@data-meta-price]/span[@color]")
    WebElement totalPriceText;




    public void addServiceItem(String text) {
        System.out.println(String.format(productXpath+"//div[@data-meta-name='AdditionalService']/button/span/span/span",currentProductId));
        serviceItemText =  driverManager.getDriver().findElements(By.xpath(String.format(productXpath+"//div[@data-meta-name='AdditionalService']/button/span/span/span",currentProductId)));
        for (WebElement item: serviceItemText ) {
            if (item.getText().contains(text)) {

                item.findElement(By.xpath("../../../../..//input")).click();
                serviceItemYear = item.findElements(By.xpath("../../../..//label"));
                products.get(currentProductId).setService(text);
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
            if (item.getDomAttribute("data-meta-value").contains(text)) {
                item.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                products.get(currentProductId).setServiceCost(Integer.parseInt(item.findElement(By.xpath("../../../..//span[@data-meta-price]/span[@color]")).getText()));
                System.out.println(item.findElement(By.xpath("../../../..//span[@data-meta-price]/span[@color]")).getText());
                return;
            }
        }
    }

    public void searchProduct (String text) {
        searchField.click();
        searchField.sendKeys(text);
        searchField.submit();
    }


    public void checkTotalPrice() {
        int summaryProductsPrice = 0;
        for (Map.Entry<Integer, Product> product: products.entrySet()) {
            summaryProductsPrice+=product.getValue().getCost();
            summaryProductsPrice+=product.getValue().getServiceCost();
        }

        totalPrice = Integer.parseInt(totalPriceText.getText().replaceAll(" ", ""));

        Assertions.assertEquals(summaryProductsPrice, totalPrice, "Сумма в корзине не соответствует сумме товаров");
    }

    public void checkServiceItemYear (String productName, String year) {
        currentProductId = 0;
        for (Map.Entry<Integer, Product> product: products.entrySet()) {
            if (product.getValue().getName().equals(productName)) {
                currentProductId = product.getKey();
                System.out.println("тест2");

            }
        }
       List<WebElement> serviceItemYears =  driverManager.getDriver().findElements(By.xpath(String.format(productXpath+"//div[@data-meta-name='AdditionalService']//label",currentProductId)));
        WebElement tempInput;
        for (WebElement element: serviceItemYears ) {
            tempInput = element.findElement(By.xpath("input"));
            if (element.getText().contains(year)) {
               Assertions.assertEquals("true", tempInput.getDomAttribute("checked"), "Аттрибут Checked не true");
                return;
            }

        }

    }




}
