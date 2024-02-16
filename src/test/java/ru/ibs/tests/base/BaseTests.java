package ru.ibs.tests.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ibs.framework.managers.DriverManager;

import java.time.Duration;

public class BaseTests {

    protected final DriverManager driverManager = DriverManager.getDriverManager();


    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void beforeEach() {

     /*   switch (System.getProperty("browser")) {
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
                driver = new ChromeDriver();
        }*/

        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driverManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driverManager.getDriver().get("https://www.citilink.ru/");

    }


    @AfterEach
    void afterEach() {
        driverManager.getDriver().quit();

    }

    @AfterAll
    static void afterAll() {


    }
}
