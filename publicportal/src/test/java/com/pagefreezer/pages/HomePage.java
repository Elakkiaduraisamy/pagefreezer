package com.pagefreezer.pages;

import com.pagefreezer.stepdefinitions.AccessibilitySteps;
import com.pagefreezer.utils.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {
    private static HomePage instance;

    @FindBy(css = "input[aria-label='searchKeyword']")
    private WebElement searchInput;

    @FindBy(css = "button.ant-btn.public-portal-search-icon")
    private WebElement searchIcon;

    @FindBy(xpath = "//nz-select[@nzplaceholder = \"Select Accounts\"]")
    private WebElement selectAccounts;

    @FindBy(xpath = "//span[text() =' Select All ']")
    private WebElement selectAll;
    @FindBy(xpath = "//span[contains(text() ,'All Social Media')]")
    private WebElement allSocialMedia;
    @FindBy(xpath = "//span[contains(text() ,'All Websites')]")
    private WebElement allWebsites;

    @FindBy(xpath = "//h2[contains(text() ,'No Results Found')]")
    private WebElement noResult;

    // Add other WebElements and methods here

    public HomePage(WebDriver driver) {
        super(driver, LogManager.getLogger(HomePage.class));
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null || !driver.equals(instance.driver)) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    public void enterSearchKeyword(String keyword) {
        seleniumUtils.waitForVisibilityOfElement(searchInput);
        searchInput.sendKeys(keyword);
    }

    public void clickSearchIconButton() {
        seleniumUtils.waitForVisibilityOfElement(searchIcon);
        searchIcon.click();
    }

    public void clickElementToSelectAccountType(String accounts) {
        seleniumUtils.waitForVisibilityOfElement(selectAccounts);
        selectAccounts.click();
        WebElement accountElement;
        if(accounts.contains("Social Media")){
            logger.info("account contains Social Media");
            accountElement = allSocialMedia;
        } else if (accounts.contains("Websites")) {
            logger.info("account contains Websites");
            accountElement = allWebsites;
        } else {
            accountElement = selectAll;
        }
        seleniumUtils.waitForVisibilityOfElement(accountElement);
        accountElement.click();
    }

    public String getTextFromHomePageNoResultElement() {
        seleniumUtils.waitForVisibilityOfElement(noResult);
        logger.info("element is visible");
        return seleniumUtils.getTextFromWebElement(noResult);
    }
    // Add other methods here
}
