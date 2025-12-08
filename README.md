# Adactin Hotel Booking – Cucumber Selenium Automation Framework

This project automates the **Adactin Hotel Booking Application** using:

* **Cucumber (BDD)**
* **Selenium WebDriver**
* **Java**
* **JUnit**
* **Maven**
* **TestNG Annotations (used inside step class)**
* **ChromeDriver / WebDriverManager**

The framework covers:
✔ Login validation
✔ Hotel search
✔ Room booking
✔ Booking confirmation
✔ Booking cancellation
✔ Logout verification

---

## 📁 Project Structure

```
mavenProject1/
│
├── src
│   ├── main
│   │   └── java
│   │
│   └── test
│       ├── java
│       │   ├── com.step
│       │   │   └── StepDefinitionClass.java
│       │   ├── com.inputs
│       │   └── com.test
│       │       └── TestRunnerClass.java
│       │
│       └── resources
│           └── Feature
│               └── write.feature
│
└── pom.xml
```

---

# 📝 **Feature File: write.feature**

```gherkin
Feature: Validate the Adactin hotel booking application

Scenario Outline: Validate of Adactin login page using valid userName and valid Password and check hotel booking fields
  Given User is on Adactin login page
  When User enters the Valid <user> and Valid <pass>
  And User clicks on the login button and validate hotel booking fields
  Then Validate the cancellation and logout messages
```

---

# 🧪 **Test Runner (JUnit)**

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features="src/test/resources/Feature/write.feature",
    glue="com.step,com.inputs"
)
public class TestRunnerClass {

}
```

🔹 Runs the feature file
🔹 Connects step definitions from `com.step` and `com.inputs`
🔹 Uses JUnit as Cucumber runner

---

# 🧩 **Step Definitions (Selenium + Cucumber)**

Your `StepDefinitionClass.java` performs the following automation steps:

### ✔ Launch browser & navigate

* Opens Chrome using WebDriverManager
* Loads Adactin homepage
* Maximizes window
* Sets wait, clears cookies

### ✔ Login

* Enters username and password
* Clicks login button

### ✔ Booking form

* Selects location
* Selects hotel
* Selects room type
* Selects number of rooms
* Enters check-in and check-out dates
* Selects adults and children
* Clicks “Search”

### ✔ Select hotel & enter customer details

* Chooses the first hotel option
* Continues to payments page
* Enters name, address, credit-card details
* Submits booking

### ✔ Cancel booking

* Opens itinerary
* Selects first booking
* Cancels
* Accepts alert

### ✔ Logout message

* Validates:
  **"You have successfully logged out."**

### ✔ After Hooks

* Prints timestamp after every test
* Prints suite completion message

---

## ▶️ Running Tests

### **Run using Maven**

```sh
mvn clean test
```

### **Run from IDE**

* Right-click `TestRunnerClass.java`
* Select **Run As → JUnit Test**

---

## ✔️ Prerequisites

* Java 8 or above
* Maven 3+
* Chrome browser
* Internet connection
* WebDriverManager dependency

---

## 📦 Sample Dependencies (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>4.8.1</version>
    </dependency>

    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>4.8.1</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.20.0</version>
    </dependency>

    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.8.0</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

# 📊 Reports

You can add reporting plugins inside the runner:

```java
plugin = {
    "pretty",
    "html:target/cucumber-report",
    "json:target/cucumber.json"
}
```

---

