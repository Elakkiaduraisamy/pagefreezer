package com.pagefreezer.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchSteps extends HomePageBaseStep {

    @When("User searches for {string}")
    public void userSearchesFor(String query) {
        logger.info("Performing search with query: " + query);
        homePage.enterSearchKeyword(query);
        homePage.clickSearchIconButton();
    }

    @Then("Search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        // Add assertions to verify search results
    }

    @And("User selects {string} in the select Account")
    public void userSelectsInTheSelectAccount(String accounts) {
        logger.info("selecting the type of Account: " + accounts);
        homePage.clickElementToSelectAccountType(accounts);

    }

    @Then("Search results should display an error message")
    public void searchResultsShouldDisplayAnErrorMessage() {
        logger.info("Verifying the Error message:");
        String actualText = homePage.getTextFromHomePageNoResultElement();
        logger.info("actual message displayed" + actualText);
        String expectedText = "No Results Found";
        Assert.assertEquals(actualText,expectedText);

    }
}
