package ru.education.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyInitializer {
    public Properties initialize(String propertyName) {
        Properties prop = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(propertyName);
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
