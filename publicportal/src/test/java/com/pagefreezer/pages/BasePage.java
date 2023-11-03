package com.pagefreezer.pages;

import com.pagefreezer.utils.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected WebDriver driver;
    protected Logger logger ;
    protected SeleniumUtils seleniumUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.logger = LogManager.getLogger(getClass());
        this.seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    // Add any common methods or utilities here
    // Example: A generic method to navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
    }

}

