package ru.ibs.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-meta-name='Snippet__title']")
    List<WebElement> snippetList;

    public void selectProductByText (String text) {
        for (WebElement item: snippetList  ) {
            if (item.getText().contains(text)) {
                item.click();
                return;
            }
        }
    }


}
