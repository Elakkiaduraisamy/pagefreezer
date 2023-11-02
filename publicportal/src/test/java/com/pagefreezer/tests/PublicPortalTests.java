//package com.pagefreezer.tests;
//
//
//import com.pagefreezer.utils.CFWebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import com.pagefreezer.pages.HomePage;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class PublicPortalTests {
//    private WebDriver driver;
//    private HomePage homePage;
//
//    @BeforeMethod
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = CFWebDriverManager.getDriver();
//        driver.get("https://betasocial.pagefreezer.com/en-US/openrecords/automation?redirected=true");
//        homePage = new HomePage(driver);
//    }
//
//    @Test
//    public void testSearchFunctionality() {
//        homePage.enterSearchKeyword("general");
//        homePage.clickSearchIconButton();
//        // Add assertions here
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
