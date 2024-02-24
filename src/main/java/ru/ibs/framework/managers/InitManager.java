package ru.ibs.framework.managers;

import java.time.Duration;

import static ru.ibs.framework.utils.PropConst.*;

public class InitManager {

    private static final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private static final DriverManager driverManager = DriverManager.getDriverManager();


    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(
                testPropManager.getProperty(PAGE_LOAD_TIMEOUT))));
        driverManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(
                testPropManager.getProperty(SCRIPT_TIMEOUT))));
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(
                testPropManager.getProperty(IMPLICITLY_WAIT))));
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }


}
