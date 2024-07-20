package io.loop.test.day8;

import io.loop.test.utilities.ConfigurationReader;

public class TestConfigurationReader {
    public static void main(String[] args) {
        System.out.println("ConfigurationReader.getProperties(\"name\") = " + ConfigurationReader.getProperties("browser"));
    }
}
