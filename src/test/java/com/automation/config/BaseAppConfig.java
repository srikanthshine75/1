package com.automation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

/**
 * BaseAppConfig - Configuration class for Selenium WebDriver setup
 * Handles browser initialization, driver configuration, and teardown
 */
public class BaseAppConfig {
    
    protected WebDriver driver;
    private String appUrl;
    private long implicitWait;
    private long pageLoadTimeout;
    
    public BaseAppConfig() {
        this.appUrl = ResourcesConfig.getProperty("app.url");
        this.implicitWait = Long.parseLong(ResourcesConfig.getProperty("implicit.wait"));
        this.pageLoadTimeout = Long.parseLong(ResourcesConfig.getProperty("page.load.timeout"));
    }
    
    /**
     * Initialize Edge WebDriver
     */
    public WebDriver initializeDriver() {
        driver = initializeEdgeDriver();
        configureDriver();
        return driver;
    }
    
    /**
     * Initialize Edge Driver
     */
    private WebDriver initializeEdgeDriver() {
        try {
            // Try WebDriverManager with offline mode
            WebDriverManager.edgedriver().setup();
            System.out.println("Edge WebDriver initialized with WebDriverManager");
        } catch (Exception e1) {
            try {
                // Fallback: Set the path to msedgedriver.exe if it exists
                String edgeDriverPath = "C:\\edgedriver\\msedgedriver.exe";
                System.setProperty("webdriver.edge.driver", edgeDriverPath);
                System.out.println("Using Edge WebDriver from: " + edgeDriverPath);
            } catch (Exception e2) {
                System.out.println("Could not find Edge WebDriver. Error: " + e2.getMessage());
            }
        }
        
        EdgeOptions options = new EdgeOptions();
        
        if (Boolean.parseBoolean(ResourcesConfig.getProperty("headless.mode"))) {
            options.addArguments("--headless");
        }
        
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        return new EdgeDriver(options);
    }
    
    /**
     * Configure driver timeouts and window
     */
    private void configureDriver() {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    /**
     * Navigate to application URL
     */
    public void navigateToApp() {
        try {
            // Wait a bit for driver to be ready
            Thread.sleep(2000);
            System.out.println("Navigating to: " + appUrl);
            driver.navigate().to(appUrl);
            System.out.println("Successfully navigated to app");
        } catch (Exception e) {
            System.out.println("Error navigating to app: " + e.getMessage());
        }
    }
    
    /**
     * Get current driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
    
    /**
     * Close browser and cleanup resources
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Get application URL
     */
    public String getAppUrl() {
        return appUrl;
    }
    
}
