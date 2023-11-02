package com.pagefreezer.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.fail;

public class AccessibilitySteps extends HomePageBaseStep  {

    private Object axeResults;
    private String axeScript;

    // Load the axe script only once and reuse
    private String getAxeScript() throws IOException {
        if (axeScript == null) {
            axeScript = new String(Files.readAllBytes(Paths.get("src/test/resources/axe.min.js")));
        }
        return axeScript;
    }

    // Method to inject the Axe script into the page
    private void injectAxeCore() throws IOException {
        ((JavascriptExecutor) driver).executeScript(getAxeScript());
    }

    @When("User perform accessibility check")
    public void userPerformAccessibilityCheck() {
        try {
            injectAxeCore();
            axeResults = ((JavascriptExecutor) driver).executeScript("return axe.run();");
            logger.info("Accessibility check performed.");
        } catch (IOException e) {
            logger.error("Failed to read axe.min.js file", e);
            fail("Failed to read axe.min.js file");
        } catch (Exception e) {
            logger.error("An unexpected error occurred during the accessibility check", e);
            fail("An unexpected error occurred during the accessibility check");
        }
    }

    @Then("User should see no accessibility violations")
    public void userShouldSeeNoAccessibilityViolations() {

        // Inject axe-core JavaScript into the page
        if (!(axeResults instanceof Map)) {
            fail("Accessibility check did not return expected results");
            logger.error("Accessibility check did not return expected results");
            return;
        }

        Map<String, Object> results = (Map<String, Object>) axeResults;
        List<Map<String, Object>> violations = (List<Map<String, Object>>) results.get("violations");

        if (violations.isEmpty()) {
            logger.info("No accessibility violations found!");
            return;
        }
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
    }

}
