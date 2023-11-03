package com.pagefreezer.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CFWebDriverManager {

    private static WebDriver driver;

    private CFWebDriverManager() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = System.getProperty("browser", "chrome").toLowerCase();
            createDriver(browserType);
            driver.manage().window().maximize();
        }
        return driver;
    }
    private static void createDriver(String browserType) {
        switch (browserType) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome": // default browser
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
