# Step-by-Step Installation & Test Run Guide

## Step 1: Install Maven (Required)

Since Maven is not installed, you need to download and install it:

### Option A: Download Maven Manually

1. Go to: https://maven.apache.org/download.cgi
2. Download: `apache-maven-3.9.6-bin.zip` (latest version)
3. Extract to: `C:\maven\` or `C:\Program Files\maven\`
4. Add to System PATH:
   - Search for "Environment Variables" in Windows
   - Click "Edit the system environment variables"
   - Click "Environment Variables" button
   - Under "System variables", click "New"
   - Variable name: `M2_HOME`
   - Variable value: `C:\maven\apache-maven-3.9.6` (or your extraction path)
   - Click OK
   - Find `Path` variable and click "Edit"
   - Click "New" and add: `C:\maven\apache-maven-3.9.6\bin` (or your path)
   - Click OK → OK → OK
5. Close and reopen PowerShell
6. Verify: Type `mvn -version`

### Option B: Using Scoop (if installed)
```powershell
scoop install maven
```

### Option C: Using Winget (Windows 11)
```powershell
winget install Apache.Maven
```

---

## Step 2: After Maven Installation - Update JIRA URL

Once Maven is installed, edit this file:
```
src/test/resources/config.properties
```

Update line 4:
```properties
app.url=https://your-jira-instance.atlassian.net
```

Replace `your-jira-instance` with your actual JIRA instance name.

---

## Step 3: Install Dependencies (One-Time Only)

After Maven is set up and PATH is updated, run:

```powershell
mvn clean install
```

This will:
- Download all required libraries
- Compile the project
- Set up the test environment

**Expected output:** BUILD SUCCESS

---

## Step 4: Run All Tests

After dependencies are installed, run:

```powershell
mvn clean test
```

This will:
- Open Edge browser automatically
- Navigate to JIRA login page
- Run all 6 tests
- Display results in terminal
- Close browser

**Expected output:** All tests PASSED ✓

---

## Step 5: Run Specific Test (Optional)

To run a single test:

```powershell
mvn test -Dtest=LoginPageTest#testLoginPageIsOpened
```

Replace `testLoginPageIsOpened` with any test name:
- `testLoginFormIsVisible`
- `testLoginButtonIsPresent`
- `testAllLoginElementsArePresent`
- `testPageTitleContainsJira`
- `testCurrentURLIsCorrect`

---

## Summary of Commands

```powershell
# Step 1: Verify Maven installed (after you install it)
mvn -version

# Step 2: Install dependencies (run once)
mvn clean install

# Step 3: Update config.properties with JIRA URL
# Edit: src/test/resources/config.properties

# Step 4: Run all tests
mvn clean test

# Step 5: Run specific test
mvn test -Dtest=LoginPageTest#testLoginPageIsOpened
```

---

## What You Should See

### After `mvn clean install`:
```
[INFO] BUILD SUCCESS
```

### After `mvn clean test`:
```
✓ testLoginPageIsOpened
✓ testLoginFormIsVisible
✓ testLoginButtonIsPresent
✓ testAllLoginElementsArePresent
✓ testPageTitleContainsJira
✓ testCurrentURLIsCorrect

[INFO] BUILD SUCCESS
```

---

## Troubleshooting

| Issue | Solution |
|-------|----------|
| mvn not found | Add Maven to PATH and restart PowerShell |
| Java not found | Install Java 11+ from oracle.com |
| Connection timeout | Check JIRA URL in config.properties |
| Tests fail | Ensure JIRA URL is accessible and correct |

---

## Next Steps

1. **Install Maven** following Option A, B, or C above
2. **Close and reopen PowerShell/Terminal** in VS Code
3. **Run:** `mvn -version` to verify Maven is installed
4. **Run:** `mvn clean install` to install dependencies
5. **Edit:** `src/test/resources/config.properties` with your JIRA URL
6. **Run:** `mvn clean test` to execute all tests

Let me know once Maven is installed and I can continue with the next steps! 🚀
