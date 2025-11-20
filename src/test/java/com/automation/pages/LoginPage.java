package com.automation.pages;

import org.openqa.selenium.WebDriver;

/**
 * LoginPage - Simple page object for Google page
 */
public class LoginPage {
    
    private WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Verify if page is loaded
     */
    public boolean isPageLoaded() {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Page loaded: " + currentUrl);
            return currentUrl.contains("google");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Get current URL
     */
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
