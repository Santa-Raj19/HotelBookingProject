
# Adactin Hotel Booking – Cucumber Selenium Automation Framework

This project automates the **Adactin Hotel Booking Application** using:

* **Cucumber (BDD)**
* **Selenium WebDriver**
* **Java**
* **JUnit**
* **Maven**
* **TestNG Annotations** (used inside step class)
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

## 📝 Feature File: `write.feature`

```gherkin
Feature: Validate the Adactin hotel booking application

Scenario Outline: Validate Adactin login page using valid credentials and check hotel booking fields
  Given User is on Adactin login page
  When User enters the Valid <user> and Valid <pass>
  And User clicks on the login button and validate hotel booking fields
  Then Validate the cancellation and logout messages
```

---

## 🧪 Test Runner (JUnit)

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features="src/test/resources/Feature/write.feature",
    glue="com.step,com.inputs",
    plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"}
)
public class TestRunnerClass {
}
```

* Runs the feature file
* Connects step definitions from `com.step` and `com.inputs`
* Uses **JUnit** as Cucumber runner
* Generates HTML & JSON reports

---

## 🧩 Step Definitions (`StepDefinitionClass.java`)

The `StepDefinitionClass.java` performs the following automation steps:

### 1. Launch Browser & Navigate

* Opens Chrome using WebDriverManager
* Loads Adactin homepage
* Maximizes window
* Sets waits and clears cookies

### 2. Login

* Enters username and password
* Clicks login button

### 3. Booking Form

* Selects location, hotel, room type, and number of rooms
* Enters check-in and check-out dates
* Selects adults and children
* Clicks **Search**

### 4. Select Hotel & Enter Customer Details

* Chooses the first hotel option
* Continues to payments page
* Enters name, address, credit card details
* Submits booking

### 5. Cancel Booking

* Opens itinerary
* Selects first booking
* Cancels and accepts alert

### 6. Logout Message

* Validates: `"You have successfully logged out."`

### 7. After Hooks

* Prints timestamp after every test
* Prints suite completion message

---

## ▶️ Running Tests

* **Maven**: `mvn clean test`
* **IDE**: Right-click `TestRunnerClass.java` → Run As → JUnit Test

---

## ✔️ Prerequisites

* Java 8 or above
* Maven 3+
* Chrome browser
* Internet connection
* WebDriverManager dependency

---

## 📦 Updated `pom.xml` Dependencies

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.sample</groupId>
  <artifactId>mavenProject1</artifactId>
  <version>0.0.1-SNAPSHOT</version>

  <dependencies>
    <!-- Selenium -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.11.0</version>
    </dependency>

    <!-- Apache POI -->
    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi-ooxml</artifactId>
      <version>4.1.2</version>
    </dependency>

    <!-- JUnit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
      <groupId>io.github.bonigarcia</groupId>
      <artifactId>webdrivermanager</artifactId>
      <version>5.3.2</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>6.14.3</version>
      <scope>test</scope>
    </dependency>

    <!-- Cucumber JUnit -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>4.2.0</version>
      <scope>test</scope>
    </dependency>

    <!-- Cucumber Java -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>4.2.0</version>
    </dependency>

    <!-- BoofCV Applet -->
    <dependency>
      <groupId>org.boofcv</groupId>
      <artifactId>applet</artifactId>
      <version>0.20</version>
    </dependency>
  </dependencies>
</project>
```
```

