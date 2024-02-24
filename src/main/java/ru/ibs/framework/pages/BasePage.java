package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.ibs.framework.data.Product;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PageManager;

import java.util.HashMap;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public static HashMap<Integer, Product> products = new HashMap<>();

    public static String currentProductName;

    public static int currentProductId;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    public void scrollToElement(WebElement element) {
        Actions action = new Actions(driverManager.getDriver());
        action.scrollToElement(element).build().perform();
    }

    public void sleep(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
