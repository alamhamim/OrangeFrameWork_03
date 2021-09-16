package com.dataProvider;

import com.utility.Helper;

import java.io.IOException;
import java.util.Properties;

public class BrowserDataProvider {

    Properties properties;

    public BrowserDataProvider() {
        try {
            properties = Helper.readProperties("Test-Data/browserData.properties");
        } catch (IOException e) {
            System.out.println("ERROR: finding the 'browserData,properties'");
        }
    }

    public String getBrowserName() {
        return properties.getProperty("browser");
    }

    public String getUrl() {
      return properties.getProperty("url");
    }
}
