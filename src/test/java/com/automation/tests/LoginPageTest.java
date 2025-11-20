package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.automation.config.BaseAppConfig;
import com.automation.pages.LoginPage;

/**
 * LoginPageTest - Opens Google in Edge and closes
 */
public class LoginPageTest extends BaseAppConfig {
    
    private LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        initializeDriver();
        navigateToApp();
        loginPage = new LoginPage(driver);
        System.out.println("Browser opened: " + getAppUrl());
    }
    
    @AfterMethod
    public void tearDown() {
        closeBrowser();
        System.out.println("Browser closed");
    }
    
    @Test(description = "Open Google and close browser")
    public void testOpenGooglePage() {
        System.out.println("Current URL: " + loginPage.getCurrentURL());
        System.out.println("Page Title: " + loginPage.getPageTitle());
        
        boolean isPageLoaded = loginPage.isPageLoaded();
        Assert.assertTrue(isPageLoaded, "Google page should be loaded");
        
        System.out.println("✓ Google page loaded successfully");
    }
}
