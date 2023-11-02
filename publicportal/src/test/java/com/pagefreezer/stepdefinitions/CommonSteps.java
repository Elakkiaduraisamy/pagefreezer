package com.pagefreezer.stepdefinitions;
import com.pagefreezer.config.ConfigReader;
import io.cucumber.java.en.Given;

public class CommonSteps extends HomePageBaseStep {

    @Given("User is on the Home Page")
    public void userIsOnTheHomePage() {
        logger.info("Navigating to the Home Page");
        homePage.navigateTo(ConfigReader.getBaseUrl());
    }
}