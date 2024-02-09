package ru.ibs.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;


    public MainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void findProduct() {

        searchField.click();
        searchField.sendKeys("playstation");
        searchField.submit();


    }

}
