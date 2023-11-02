package com.pagefreezer.pages;

import com.pagefreezer.utils.SeleniumUtils;
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

    private SeleniumUtils seleniumUtils;

    // Add other WebElements and methods here

    public HomePage(WebDriver driver) {
        super(driver);
        this.seleniumUtils = new SeleniumUtils(driver);
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

    // Add other methods here
}
