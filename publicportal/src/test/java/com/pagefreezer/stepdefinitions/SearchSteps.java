package com.pagefreezer.stepdefinitions;

import com.pagefreezer.config.ConfigReader;
import com.pagefreezer.pages.HomePage;
import com.pagefreezer.utils.CFWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class);
    WebDriver driver = CFWebDriverManager.getDriver();
    HomePage homePage = HomePage.getInstance(driver);


    @Given("User is on the Home Page")
    public void userIsOnTheHomePage() {
        logger.info("Navigating to the Home Page");
        homePage.navigateTo(ConfigReader.getBaseUrl());
    }

    @When("User searches for {string}")
    public void userSearchesFor(String query) {
        logger.info("Performing search with query: " + query);
        homePage.enterSearchKeyword(query);
    }

    @Then("Search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        // Add assertions to verify search results
    }

}