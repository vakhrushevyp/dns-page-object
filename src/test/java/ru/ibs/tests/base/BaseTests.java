package ru.ibs.tests.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.TestPropManager;
import ru.ibs.framework.utils.PropConst;

public class BaseTests {

    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();
    protected PageManager pageManager = PageManager.getPageManager();


    @BeforeAll
    static void beforeAll() {

        InitManager.initFramework();
    }

    @BeforeEach
    void beforeEach() {

        DriverManager.getDriverManager().getDriver()
                .get(testPropManager.getProperty(PropConst.BASE_URL));
    }


    @AfterEach
    void afterEach() {

    }

    @AfterAll
    static void afterAll() {

        InitManager.quitFramework();

    }
}
