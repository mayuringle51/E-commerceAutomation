# E-commerceAutomation
# 🛍️ SauceDemo E2E Automation (POM + Java + Selenium)

✅ Goal

Automates the end-to-end order flow:
1. Launch site
2. Login
3. Add an item to the cart
4. Open cart & validate item is added
5. Proceed to checkout
6. Enter user details
7. Complete the order
8. Validate the “Thank you” page


### ⚡️ Features
- Pure Java + Selenium (no TestNG required).
- Page Object Model for maintainability.
- Properties file for test data.

---

### 🗂️ Project Structure
src/main/java/

├─ pages/

│ └─ LoginPage.java

│ └─ ProductsPage.java

│ └─ CartPage.java

│ └─ CheckoutPage.java

├─ E2EFlow.java

src/test/resources/testdata/

├─ user.properties

### ⚡️ Prerequisites
- Java 17+
- Maven
- Chrome Browser
- Internet Connection

---

### ⚡️ Test Data
Edit `user.properties`:


### ⚡️ Run the Test
```bash
mvn compile
mvn compile exec:java -Dexec.mainClass="E2EFlow"
