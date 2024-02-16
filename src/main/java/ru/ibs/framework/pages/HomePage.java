package ru.ibs.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.ibs.framework.managers.DriverManager;

import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;





    public void searchProduct () {
        searchField.click();
        searchField.sendKeys("playstation");
        searchField.submit();
    }







}
