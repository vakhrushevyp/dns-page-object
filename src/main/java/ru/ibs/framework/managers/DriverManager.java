package ru.ibs.framework.managers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.ibs.framework.utils.PropConst;


public class DriverManager {

    private WebDriver driver = null;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();


    private static DriverManager INSTANCE = null;

    private DriverManager() {

    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;

    }

    private void initDriver() {

        switch (testPropManager.getProperty(PropConst.TYPE_BROWSER)) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                Assertions.fail("тип браузера '" +
                        testPropManager.getProperty(PropConst.TYPE_BROWSER) +
                        "' не указан во фреймворке");
        }


    }

    public void quitDriver() {
        driver.quit();
    }
}
