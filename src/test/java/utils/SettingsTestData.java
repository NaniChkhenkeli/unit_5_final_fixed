package utils;

import models.EnvData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsTestData {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("downloads")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load test data properties file", e);
        }
    }

    public static final String WIKIPEDIA_URL = "https://www.wikipedia.org/";
    public static final String ALBERT_EINSTEIN = "Albert Einstein";
    public static final String BENGAL_TIGER = "Bengal tiger";
    public static final String GABRIEL_GARCIA_MARQUEZ = "Gabriel García Márquez";

    public static EnvData getEnvData() {
        return new EnvData(properties);
    }




}
