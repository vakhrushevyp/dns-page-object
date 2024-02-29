package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.data.Product;

import java.util.List;
import java.util.Map;

public class BasketPage extends BasePage {


    int totalPrice;

    String productXpath = "//div[@data-meta-name='BasketSnippet' and @data-meta-id='%d']";

    List<WebElement> serviceItemText;


    @FindBy(xpath = "//div[@data-meta-name='AdditionalService']/button/span/span/span")
    List<WebElement> serviceItemYear;

    @FindBy(xpath = "//div[@data-meta-name='BasketSummary']//span[@data-meta-price]/span[@color]")
    WebElement totalPriceText;

    @Step("Добавляем продукту услугу {text}")
    public BasketPage addServiceItem(String text) {
        System.out.printf(productXpath + "//div[@data-meta-name='AdditionalService']/button/span/span/span%n", currentProductId);
        serviceItemText = driverManager.getDriver().findElements(By.xpath(String.format(productXpath + "//div[@data-meta-name='AdditionalService']/button/span/span/span", currentProductId)));
        for (WebElement item : serviceItemText) {
            if (item.getText().contains(text)) {
                item.findElement(By.xpath("../../../../..//input")).click();
                addScreenshot();
                serviceItemYear = item.findElements(By.xpath("../../../..//label"));
                products.get(currentProductId).setService(text);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return this;
            }
        }
        return this;
    }
    @Step("Добавляем к услуге срок действия {text}")
    public BasketPage setServiceItemYear(String text) {
        for (WebElement item : serviceItemYear) {
            if (item.getDomAttribute("data-meta-value").contains(text)) {
                item.click();
                addScreenshot();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                products.get(currentProductId).setServiceCost(Integer.parseInt(item.findElement(By.xpath("../../../..//span[@data-meta-price]/span[@color]")).getText()));
                System.out.println(item.findElement(By.xpath("../../../..//span[@data-meta-price]/span[@color]")).getText());
                return this;
            }
        }
        return this;
    }
    @Step("Поиск продоктов с названием {text}")
    public SearchPage searchProduct(String text) {
        searchField.click();
        searchField.sendKeys(text);
        searchField.submit();
        addScreenshot();
        return pageManager.getSearchPage();
    }

    @Step("Проверяем соответствие суммы корзины и суммы товаров")
    public BasketPage checkTotalPrice() {
        int summaryProductsPrice = 0;
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            summaryProductsPrice += product.getValue().getCost();
            summaryProductsPrice += product.getValue().getServiceCost();
        }

        totalPrice = Integer.parseInt(totalPriceText.getText().replaceAll(" ", ""));


        Assertions.assertEquals(summaryProductsPrice, totalPrice, "Сумма в корзине не соответствует сумме товаров");
        addScreenshot();
        return this;
    }

    @Step("Проверяем что у {productName} в услуге выбран срок {year}")
    public void checkServiceItemYear(String productName, String year) {
        currentProductId = 0;
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getName().equals(productName)) {
                currentProductId = product.getKey();
            }
        }
        List<WebElement> serviceItemYears = driverManager.getDriver().findElements(By.xpath(String.format(productXpath + "//div[@data-meta-name='AdditionalService']//label", currentProductId)));
        WebElement tempInput;
        for (WebElement element : serviceItemYears) {
            tempInput = element.findElement(By.xpath("input"));
            if (element.getText().contains(year)) {
                addScreenshot();
                Assertions.assertEquals("true", tempInput.getDomAttribute("checked"), "Аттрибут Checked не true");
                return;
            }

        }

    }


}
