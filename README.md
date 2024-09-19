# Diploma Project (part №3): Web Application Testing for Stellar Burgers

## Overview
This project involves testing the Stellar Burgers web application using the Page Object Model (POM) approach. The tests are conducted in both Google Chrome and Yandex Browser to ensure cross-browser compatibility, and Allure is integrated for detailed reporting.

## Key Technologies
- **Selenium WebDriver**: For automating web application testing.
- **JUnit 4**: For structuring the test cases.
- **Allure**: For generating and displaying test reports.

## Objectives
1. Implement the Page Object Model to describe the web elements used in tests.
2. Test functionality in:
   - Google Chrome
   - Yandex Browser
3. Validate the following functionalities:
   - **Registration**:
     - Successful registration.
     - Error handling for invalid passwords (minimum six characters).
   - **Login**:
     - Login via the "Log in to Account" button on the main page.
     - Login through the "Personal Cabinet" button.
     - Login from the registration form.
     - Login from the password recovery form.
   - **Navigate to Personal Cabinet**:
     - Verify transition by clicking on "Personal Cabinet".
   - **Transition from Personal Cabinet to Constructor**:
     - Validate navigation by clicking on "Constructor" and the Stellar Burgers logo.
   - **Logout**:
     - Test logout functionality using the "Logout" button in the personal cabinet.
   - **Constructor Section**:
     - Verify navigation to the following sections:
       - "Buns"
       - "Sauces"
       - "Fillings"

## Implementation

### Page Objects
- Create separate classes for each page, encapsulating the web elements and methods that interact with them.

### Test Cases
1. **Registration Tests**:
   - Verify successful registration.
   - Check for error message when an invalid password is used.

2. **Login Tests**:
   - Validate login functionality through various entry points.

3. **Navigation Tests**:
   - Ensure correct navigation to the Personal Cabinet and Constructor sections.

4. **Logout Tests**:
   - Confirm successful logout from the account.

## Running the Project

### Prerequisites
- **Java 8 or higher**
- **Maven** for dependencies
- **JUnit 4**, **Selenium WebDriver**, and **Allure**

  
### Steps
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Navigate to the project directory:
   ```bash
   cd <project_name>
   ```
3. Run tests:
   ```bash
   ./gradlew test
   ```
4. Generate code coverage report:
   ```bash
   ./gradlew jacocoTestReport
   ```

# Reports
The Allure report will be automatically generated and opened in your default browser after running mvn allure:serve.

# Conclusion
This project demonstrates comprehensive testing of the Stellar Burgers web application using the Page Object Model. By validating key functionalities and ensuring cross-browser compatibility, the project highlights best practices in web application testing with detailed reporting through Allure.
