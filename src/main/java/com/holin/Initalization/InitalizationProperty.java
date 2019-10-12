package com.holin.Initalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InitalizationProperty {

    private static InitalizationProperty instance = null;
    private static Properties initProperties = new Properties();

    public static String getInitProperty(String key) {
        return initProperties.getProperty(key);
    }

    public static String getInitPropertyOrDefault(String key, String defaultData) {
        return initProperties.getProperty(key, defaultData);
    }

    private InitalizationProperty() {
        try {
            initProperties.load(new FileInputStream(new File("src/test/resources/InitData.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static InitalizationProperty getInstance() {
        if (instance == null) {
            instance = new InitalizationProperty();
        }
        return instance;
    }

}
