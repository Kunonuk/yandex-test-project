package com.yandex.config;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ConfigCapability implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().setup();

        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());

        try {
            return new ChromeDriver(desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static WebDriver getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }
}
