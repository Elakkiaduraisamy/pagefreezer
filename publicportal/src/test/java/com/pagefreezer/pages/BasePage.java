package com.pagefreezer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Add any common methods or utilities here
    // Example: A generic method to navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }

}

