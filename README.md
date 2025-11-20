# JIRA Selenium Automation Tests

Automated tests for verifying JIRA login page functionality using Selenium WebDriver.

## Prerequisites

- **Java 11+** - `java -version`
- **Maven 3.6+** - `mvn -version`

## Quick Start

### 1. Update JIRA URL
Edit `src/test/resources/config.properties`:
```properties
app.url=https://your-jira-instance.atlassian.net
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Run All Tests
```bash
mvn clean test
```

## Terminal Commands

| Command | Description |
|---------|-------------|
| `mvn clean install` | Install all dependencies (first time only) |
| `mvn clean test` | Run all tests |
| `mvn test -Dtest=LoginPageTest` | Run all tests in LoginPageTest class |
| `mvn test -Dtest=LoginPageTest#testLoginPageIsOpened` | Run specific test |

## Browser Configuration

Edit `config.properties` to change browser:
```properties
browser=edge        # Options: chrome, firefox, edge
headless.mode=false # Set to true for headless mode
```

## Test Cases

- `testLoginPageIsOpened` - Login page loads
- `testLoginFormIsVisible` - Login form is visible
- `testLoginButtonIsPresent` - Login button exists
- `testAllLoginElementsArePresent` - All elements present
- `testPageTitleContainsJira` - Page title valid
- `testCurrentURLIsCorrect` - URL is correct

## Project Structure

```
├── pom.xml
├── src/test/
│   ├── java/com/automation/
│   │   ├── config/
│   │   │   ├── BaseAppConfig.java
│   │   │   └── ResourcesConfig.java
│   │   ├── pages/
│   │   │   └── LoginPage.java
│   │   └── tests/
│   │       └── LoginPageTest.java
│   └── resources/
│       ├── config.properties
│       └── testng.xml
```

## Troubleshooting

- **mvn not found**: Install Maven and add to PATH
- **Java not found**: Install Java 11+ and add to PATH
- **Connection timeout**: Check JIRA URL in config.properties
- **Element not found**: Update selectors in LoginPage.java
