package ru.ibs.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.ibs.framework.managers.DriverManager;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driverManager.getDriver(),this);
    }

}
