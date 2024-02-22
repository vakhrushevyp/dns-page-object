package ru.ibs.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.ibs.framework.Data.Product;
import ru.ibs.framework.managers.DriverManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driverManager.getDriver(),this);
    }

    public static HashMap<Integer, Product> products = new HashMap<>();

    public static String currentProductName;

    public static int currentProductId;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;




}
