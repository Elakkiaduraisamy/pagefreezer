package com.pagefreezer.stepdefinitions;

import com.pagefreezer.config.ConfigReader;
import com.pagefreezer.utils.CFWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.pagefreezer.pages.HomePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.fail;

public class AccessibilitySteps {
    private static final Logger logger = LogManager.getLogger(AccessibilitySteps.class);
    WebDriver driver = CFWebDriverManager.getDriver();
    HomePage homePage = HomePage.getInstance(driver);

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {

        homePage.navigateTo(ConfigReader.getBaseUrl());
    }

    @When("I perform accessibility check")
    public void i_perform_accessibility_check() {
        // Implement accessibility check using axe-core
        // You can follow the previous example to inject axe-core and run the checks
    }

    @Then("I should see no accessibility violations")
    public void i_should_see_no_accessibility_violations() {
        try {
            // Inject axe-core JavaScript into the page
            String axeScript = new String(Files.readAllBytes(Paths.get("src/test/resources/axe.min.js")));
            ((JavascriptExecutor) driver).executeScript(axeScript);

            // Run axe-core accessibility checks
            String script = "return axe.run();";
            Object response = ((JavascriptExecutor) driver).executeScript(script);

            // Log the results and assert no violations
            if (response instanceof Map) {
                Map<String, Object> results = (Map<String, Object>) response;
                List<Map<String, Object>> violations = (List<Map<String, Object>>) results.get("violations");
                if (violations.size() > 0) {
                    for (Map<String, Object> violation : violations) {
                        logger.error("Violation: " + violation.get("description"));
                        logger.error("Impact: " + violation.get("impact"));
                        logger.error("Help: " + violation.get("help"));
                        logger.error("Help URL: " + violation.get("helpUrl"));
                        List<Map<String, Object>> nodes = (List<Map<String, Object>>) violation.get("nodes");
                        for (Map<String, Object> node : nodes) {
                            logger.error("Element: " + node.get("html"));
                        }
                    }
                    fail("Accessibility violations found!");
                } else {
                    logger.info("No accessibility violations found!");
                }
            } else {
                logger.error("Accessibility check did not return expected results");
                fail("Accessibility check did not return expected results");
            }
        } catch (IOException e) {
            logger.error("Failed to read axe.min.js file", e);
            fail("Failed to read axe.min.js file");
        } catch (Exception e) {
            logger.error("An unexpected error occurred during the accessibility check", e);
            fail("An unexpected error occurred during the accessibility check");
        }
    }

}
