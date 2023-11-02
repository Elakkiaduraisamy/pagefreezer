package com.pagefreezer.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebsitesTabSteps extends HomePageBaseStep  {

    @When("User click on the {string} tab")
    public void userClickOnTheTab(String tabName) {
        logger.info("clicking on tab " + tabName);
        homePage.clickTabElement(tabName);
    }

    @Then("User should see a table with more than {int} rows")
    public void userShouldSeeATableWithMoreThanRows(int rowCount) {
        logger.info("Verifying the record count in the table:");
        List<WebElement> actualRows = homePage.getRowCountFromTheTable(".ant-table-tbody .ant-table-row");
        logger.info("rowCount in the table" + actualRows.size());
        Assert.assertTrue(actualRows.size() > rowCount, "Table does not have more than " + rowCount + " rows");
    }





}

