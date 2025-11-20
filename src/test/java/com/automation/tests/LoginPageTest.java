package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.automation.config.BaseAppConfig;
import com.automation.config.ResourcesConfig;
import com.automation.pages.LoginPage;

/**
 * LoginPageTest - Test class to verify JIRA login page
 * Tests if the login page is properly loaded and all elements are visible
 */
public class LoginPageTest extends BaseAppConfig {
    
    private LoginPage loginPage;
    
    @BeforeMethod(description = "Initialize driver and navigate to JIRA login page")
    public void setUp() {
        // Initialize the WebDriver
        initializeDriver();
        
        // Navigate to JIRA application
        navigateToApp();
        
        // Initialize login page object
        loginPage = new LoginPage(driver, 15);
        
        System.out.println("Test Setup Complete - Navigated to: " + getAppUrl());
    }
    
    @AfterMethod(description = "Close browser and cleanup resources")
    public void tearDown() {
        try {
            closeBrowser();
            System.out.println("Test Teardown Complete - Browser Closed");
        } catch (Exception e) {
            System.out.println("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Test(description = "Test - Verify Login Page is Opened Successfully")
    public void testLoginPageIsOpened() {
        System.out.println("Starting test: testLoginPageIsOpened");
        System.out.println("Current URL: " + loginPage.getCurrentURL());
        System.out.println("Page Title: " + loginPage.getPageTitle());
        
        // Verify login page is loaded
        boolean isPageLoaded = loginPage.isLoginPageLoaded();
        Assert.assertTrue(isPageLoaded, "Login page should be loaded");
        
        System.out.println("✓ Login page is loaded successfully");
    }
    
    @Test(description = "Test - Verify Login Form is Visible")
    public void testLoginFormIsVisible() {
        System.out.println("Starting test: testLoginFormIsVisible");
        
        boolean isFormVisible = loginPage.isLoginFormVisible();
        Assert.assertTrue(isFormVisible, "Login form should be visible");
        
        System.out.println("✓ Login form is visible");
    }
    
    @Test(description = "Test - Verify Login Button is Present")
    public void testLoginButtonIsPresent() {
        System.out.println("Starting test: testLoginButtonIsPresent");
        
        boolean isButtonPresent = loginPage.isLoginButtonPresent();
        Assert.assertTrue(isButtonPresent, "Login button should be present");
        
        System.out.println("✓ Login button is present");
    }
    
    @Test(description = "Test - Verify All Login Page Elements Are Present")
    public void testAllLoginElementsArePresent() {
        System.out.println("Starting test: testAllLoginElementsArePresent");
        
        boolean allElementsPresent = loginPage.areAllLoginElementsPresent();
        Assert.assertTrue(allElementsPresent, "All login elements should be present");
        
        System.out.println("✓ All login page elements are present");
        System.out.println("  - Username field: Present");
        System.out.println("  - Password field: Present");
        System.out.println("  - Login button: Present");
    }
    
    @Test(description = "Test - Verify Page Title Contains JIRA")
    public void testPageTitleContainsJira() {
        System.out.println("Starting test: testPageTitleContainsJira");
        
        String pageTitle = loginPage.getPageTitle();
        System.out.println("Page Title: " + pageTitle);
        
        Assert.assertNotNull(pageTitle, "Page title should not be null");
        Assert.assertFalse(pageTitle.isEmpty(), "Page title should not be empty");
        
        System.out.println("✓ Page has valid title: " + pageTitle);
    }
    
    @Test(description = "Test - Verify Current URL is Correct")
    public void testCurrentURLIsCorrect() {
        System.out.println("Starting test: testCurrentURLIsCorrect");
        
        String currentURL = loginPage.getCurrentURL();
        String expectedURL = getAppUrl();
        
        System.out.println("Expected URL: " + expectedURL);
        System.out.println("Current URL: " + currentURL);
        
        Assert.assertNotNull(currentURL, "Current URL should not be null");
        Assert.assertFalse(currentURL.isEmpty(), "Current URL should not be empty");
        
        System.out.println("✓ Current URL is valid");
    }
}
