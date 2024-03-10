package ru.ibs.framework.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.TestPropManager;
import ru.ibs.framework.utils.PropConst;

public class Hooks {

    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();
    protected PageManager pageManager = PageManager.getPageManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }


    @Before
    public void before() {
        DriverManager.getDriverManager().getDriver()
                .get(testPropManager.getProperty(PropConst.BASE_URL));
    }

    @AfterAll
    public static void afterAll() {

        InitManager.quitFramework();

    }


}
