package com.pagefreezer.utils;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @BeforeAll
    public static void setUp() {
        WebDriver driver = CFWebDriverManager.getDriver();
        // Any other setup code goes here
    }

    @AfterAll
    public static void tearDown() {
        CFWebDriverManager.closeDriver();
    }
}

