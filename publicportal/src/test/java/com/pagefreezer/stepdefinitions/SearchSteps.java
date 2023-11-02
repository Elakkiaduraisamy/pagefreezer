package com.pagefreezer.stepdefinitions;

import com.pagefreezer.config.ConfigReader;
import com.pagefreezer.pages.HomePage;
import com.pagefreezer.utils.CFWebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchSteps {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class);
    WebDriver driver = CFWebDriverManager.getDriver();
    HomePage homePage = HomePage.getInstance(driver);


    @Given("User is on the Home Page")
    public void userIsOnTheHomePage() {
        logger.info("Navigating to the Home Page");
        homePage.navigateTo(ConfigReader.getBaseUrl());
    }

    @And("User selects {string} in the select Account")
    public void userSelectsInTheSelectAccount(String accounts) {
        logger.info("selecting the type of Account: " + accounts);
        homePage.clickElementToSelectAccountType(accounts);

    }

    @When("User searches for {string}")
    public void userSearchesFor(String query) {
        logger.info("Performing search with query: " + query);
        homePage.enterSearchKeyword(query);
        homePage.clickSearchIconButton();
    }

    @Then("Search results should display an error message")
    public void searchResultsShouldDisplayAnErrorMessage() {
        logger.info("Verifying the Error message:");
        String actualText = homePage.getTextFromHomePageNoResultElement();
        logger.info("actual message displayed" + actualText);
        String expectedText = "No Results Found";
        Assert.assertEquals(actualText,expectedText);

    }
    @Then("Search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        // Add assertions to verify search results
    }

}
