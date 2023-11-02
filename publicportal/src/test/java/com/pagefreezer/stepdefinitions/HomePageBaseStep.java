package com.pagefreezer.stepdefinitions;

import com.pagefreezer.pages.HomePage;
import com.pagefreezer.utils.CFWebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePageBaseStep {

    protected static final Logger logger = LogManager.getLogger(HomePageBaseStep.class);
    protected WebDriver driver;
    protected HomePage homePage;

    public HomePageBaseStep() {
        this.driver = CFWebDriverManager.getDriver();
        this.homePage = HomePage.getInstance(driver);
    }
}
