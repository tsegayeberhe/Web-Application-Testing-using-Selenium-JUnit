# 🚀 Selenium Automation Framework (Java | JUnit | Maven)

## 📌 Overview

This project is a **robust, scalable test automation framework** built using:

* **Java**
* **Selenium WebDriver**
* **JUnit (Test Framework)**
* **Maven (Build & Dependency Management)**

It follows the **Page Object Model (POM)** design pattern to ensure:

* High maintainability
* Code reusability
* Reduced test flakiness
* Clear separation of concerns

---

## 🏗️ Project Structure

```
project-root/
│── src/
│   ├── main/java/
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   └── HomePage.java
│   │   └── utils/
│   │       └── DriverFactory.java
│   │
│   ├── test/java/
│   │   ├── tests/
│   │   │   ├── BaseTest.java
│   │   │   ├── LoginTests.java
│   │   │   └── HomePageTests.java
│
│── pom.xml
│── README.md
```

---

## ⚙️ Tech Stack

| Tool               | Purpose                       |
| ------------------ | ----------------------------- |
| Selenium WebDriver | Browser automation            |
| JUnit              | Test execution & assertions   |
| Maven              | Dependency management & build |
| WebDriverManager   | Automatic driver setup        |

---

## 🔧 Setup Instructions

### 1. Prerequisites

* Java JDK 8+
* Maven installed
* Chrome / Firefox browser

### 2. Clone the Repository

```bash
git clone https://github.com/your-username/selenium-framework.git
cd selenium-framework
```

### 3. Install Dependencies

```bash
mvn clean install
```

---

## ▶️ Running Tests

### Run all tests:

```bash
mvn test
```

### Run a specific test:

```bash
mvn -Dtest=LoginTests test
```

---

## 🧪 Test Coverage

### ✅ Functional Testing

* Login functionality (valid/invalid credentials)
* Logout flow validation

### 🎨 UI Testing

* Element visibility checks
* Page navigation verification

### 🔁 Regression Testing

* Ensures core workflows remain stable after updates

---

## 🧱 Framework Components

### 🔹 BaseTest

* Handles WebDriver setup & teardown
* Supports multiple browsers (Chrome, Firefox)
* Uses **WebDriverWait** for synchronization (no hardcoded sleeps)

### 🔹 Page Object Model (POM)

Each page is represented as a class:

* Encapsulates locators (`By`)
* Contains reusable actions (methods)

Example:

```java
public class LoginPage {
    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
```

---

## 🧠 Best Practices Implemented

✔ Page Object Model (POM)
✔ Explicit waits (`WebDriverWait`) to handle dynamic elements
✔ Clean and modular architecture
✔ Reusable test components
✔ Descriptive test method names
✔ Separation of test logic and UI interactions

---

## ⚠️ Common Issues Solved

### ❌ Flaky Tests

✔ Fixed using explicit waits instead of `Thread.sleep()`

### ❌ Synchronization Problems

✔ Handled using `ExpectedConditions`

### ❌ Code Duplication

✔ Eliminated via reusable page objects

---

## 📈 Future Enhancements

* Add **TestNG support**
* Integrate **Allure Reports / Extent Reports**
* Add **CI/CD (GitHub Actions / Jenkins)**
* Cross-browser parallel execution
* Data-driven testing (CSV/Excel/JSON)

---

## 🤝 Contribution

Contributions are welcome! Feel free to:

* Fork the repo
* Create a feature branch
* Submit a pull request

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Authors

**Names
ID
1.Sisiyo TakeleETS 1252/15
2.Solan AdugnaETS 1260/15
3.Tsegaye BerheETS 1325/15
4.Ruth AredaETS1519/15
5.Yeabsra YidegETS1399/15
6.Yodit GirmaETS1422/15**

Software Engineering Student | QA Automation Enthusiast

---

## ⭐ Final Note

This framework is designed to reflect **industry-level automation practices**, making it suitable for:

* Academic projects
* Portfolio building
* Real-world QA automation workflows

---
