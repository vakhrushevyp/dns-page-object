package ru.ibs.framework.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {


    private final Properties properties = new Properties();


    private static TestPropManager INSTANCE = null;

    private TestPropManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    public static TestPropManager getTestPropManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }


    public void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propFile", "application") +
                    ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties().
                forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) && !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }


}
