package models;

import lombok.Getter;

import java.util.Properties;

@Getter
public class EnvData {
    private String host;
    private int wait;

    public EnvData(Properties properties) {
        this.host = properties.getProperty("host");
        this.wait = Integer.parseInt(properties.getProperty("wait"));
    }
}
