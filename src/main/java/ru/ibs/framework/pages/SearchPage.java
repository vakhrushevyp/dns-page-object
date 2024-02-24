package ru.ibs.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.data.Product;

import java.util.List;

public class SearchPage extends BasePage {


    @FindBy(xpath = "//a[@data-meta-name='Snippet__title']")
    List<WebElement> snippetList;

    public ProductPage selectProductByText(String text) {
        currentProductName = text;
        for (WebElement item : snippetList) {
            if (item.getText().contains(text)) {
                Product product = new Product();
                product.setName(text);
                currentProductId = Integer.parseInt(item.findElement(By.xpath("../../..")).getDomAttribute("data-meta-product-id"));
                product.setCode(currentProductId);
                products.put(currentProductId, product);
                moveToElement(item);
                sleep(1000);
                item.click();
                return new ProductPage();
            }
        }
        return pageManager.getProductPage();
    }


}
