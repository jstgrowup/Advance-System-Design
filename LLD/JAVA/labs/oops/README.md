# ChaiCode Java OOPS Labs

Master Object-Oriented Programming in Java through **28 real-world, story-based challenges**. Each exercise puts you in a practical scenario — car rentals, UPI checkout, smart-home automation, sealed payment results, and more.

**232 JUnit tests across 14 topics**

Edit the Java files on your machine and run tests with Maven. Only edit files under `src/main/java/` — never change the test files.

Curriculum follows the [OOPS in Java Complete Notes](https://app.notion.com/p/OOPS-in-Java-Complete-Notes-3b7c3158e38d801b9551f209048fb582) in four phases: Foundations → Core Pillars → Intermediate OOP → Modern OOP.

---

## Table of contents

1. [Prerequisites](#prerequisites)
2. [Setup guide](#setup-guide)
3. [How to run tests](#how-to-run-tests)
4. [Topics covered](#topics-covered)
5. [Suggested learning order](#suggested-learning-order)
6. [Project structure](#project-structure)
7. [How to solve a challenge](#how-to-solve-a-challenge)
8. [Challenge index](#challenge-index)
9. [Troubleshooting](#troubleshooting)
10. [Progress checklist](#progress-checklist)

---

## Prerequisites

Everything you need before opening the project.

### Required

| Requirement | Minimum version | Why you need it |
|-------------|-----------------|-----------------|
| **Java JDK** | 17 or higher | Compiles and runs the lab code |
| **Internet connection** | — | First Maven run downloads JUnit and dependencies |
| **Terminal** | — | PowerShell, Command Prompt, or Mac/Linux terminal |

### Optional (recommended)

| Tool | Why it helps |
|------|--------------|
| **VS Code** or **IntelliJ IDEA** | Edit Java with syntax highlighting and one-click test runs |
| **Extension Pack for Java** (VS Code) | Run individual tests from the editor |
| **Git** | Version control for your solutions |

### You do NOT need

| Tool | Reason |
|------|--------|
| **Maven installed globally** | This project includes `mvnw` / `mvnw.cmd` (Maven Wrapper) |
| **Paid IDE license** | IntelliJ Community Edition is free and works fine |

### System requirements

- **Windows 10/11**, **macOS**, or **Linux**
- ~200 MB disk space (more after first Maven build in `target/`)
- JDK 17+ from [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/downloads/)

---

## Setup guide

Follow these steps once before you start solving challenges.

### Step 1 — Install Java JDK 17+

**Windows**

1. Download JDK 17+ from [Adoptium](https://adoptium.net/)
2. Run the installer (keep default options)
3. Restart your terminal and IDE after install

**macOS**

```bash
brew install openjdk@17
```

Or download from Adoptium and install the `.pkg`.

**Linux (Ubuntu/Debian)**

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### Step 2 — Verify Java is installed

Open a terminal and run:

```bash
java -version
```

You should see output like:

```
openjdk version "17.0.x" ...
```

Also check the compiler:

```bash
javac -version
```

If either command is not found, Java is not on your PATH. Reinstall JDK or add `JAVA_HOME` to your environment variables.

**Windows — set JAVA_HOME (if IDE cannot find Java)**

1. Search **Environment Variables** in Windows
2. Add a new system/user variable:
   - Name: `JAVA_HOME`
   - Value: `C:\Program Files\Eclipse Adoptium\jdk-17.x.x-hotspot` (your actual JDK path)
3. Add `%JAVA_HOME%\bin` to your `Path` variable
4. Restart terminal and IDE

### Step 3 — Get the project on your machine

If you already have the folder, skip to Step 4.

```bash
# Example — clone or copy the project folder
cd ~/coding-playground
# Your project should be at:
# ~/coding-playground/chaicode-java-oops-labs
```

### Step 4 — Open the project

**VS Code**

1. **File → Open Folder**
2. Select `chaicode-java-oops-labs` (the folder that contains `pom.xml`)
3. Install **Extension Pack for Java** when prompted
4. Wait for the Java language server to finish loading (status bar bottom-right)

**IntelliJ IDEA**

1. **File → Open**
2. Select the `chaicode-java-oops-labs` folder
3. IntelliJ detects Maven automatically — click **Load Maven Project** if asked

### Step 5 — First build (download dependencies)

Open a terminal **in the project root** (where `pom.xml` lives).

**Windows (PowerShell or Command Prompt)**

```powershell
cd C:\coding-playground\chaicode-java-oops-labs
.\mvnw.cmd test
```

**macOS / Linux**

```bash
cd /path/to/chaicode-java-oops-labs
chmod +x mvnw
./mvnw test
```

**What to expect on first run**

- Maven downloads JUnit and plugins (1–3 minutes depending on network)
- You will see **many failing tests** — this is normal
- Your job is to implement the classes and make tests pass

**Successful first run looks like:**

```
Tests run: 232, Failures: ..., Errors: ...
BUILD SUCCESS   ← build succeeded (tests may still fail until you write code)
```

If the build itself fails (compile errors, Maven not found), see [Troubleshooting](#troubleshooting).

### Step 6 — Fix PowerShell execution policy (Windows only, if needed)

If you see:

```
.\mvnw.cmd cannot be loaded because running scripts is disabled
```

Run once:

```powershell
Set-ExecutionPolicy -Scope CurrentUser RemoteSigned
```

Or use **Command Prompt** instead:

```cmd
cd C:\coding-playground\chaicode-java-oops-labs
mvnw.cmd test
```

### Step 7 — Confirm you are in the right folder

Your terminal should list these files:

```
pom.xml
mvnw.cmd        (Windows) or mvnw (Mac/Linux)
README.md
src/
```

Always run Maven commands from this folder, not from `src/`.

---

## How to run tests

All commands below assume you are in the project root.

**Windows:** use `.\mvnw.cmd`  
**macOS / Linux:** use `./mvnw`

---

### Run ALL tests (entire lab)

Runs every test class in the project (232 tests).

```powershell
.\mvnw.cmd test
```

```bash
./mvnw test
```

Use this to check overall progress after completing several challenges.

**Example output when done:**

```
Tests run: 232, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

### Run ONE challenge (entire test class)

Each challenge has one test class, e.g. `CarTest` for `Car.java`.

```powershell
.\mvnw.cmd test -Dtest=CarTest
```

```bash
./mvnw test -Dtest=CarTest
```

**More examples:**

```powershell
.\mvnw.cmd test -Dtest=LibraryBookTest
.\mvnw.cmd test -Dtest=PaymentTest
.\mvnw.cmd test -Dtest=SmartHomeTest
.\mvnw.cmd test -Dtest=MoneyTest
```

This is the recommended way to work — solve one challenge, run its test class, then move on.

---

### Run a SINGLE test case (one test method)

Use `ClassName#methodName` to run exactly one test.

```powershell
.\mvnw.cmd test -Dtest=CarTest#describe
```

```bash
./mvnw test -Dtest=CarTest#describe
```

**More examples:**

```powershell
.\mvnw.cmd test -Dtest=StudentAdmissionTest#rejectsBlankName
.\mvnw.cmd test -Dtest=ReportCardTest#gradeFollowsMarks
.\mvnw.cmd test -Dtest=ShippingPartnerTest#cheapestPartnerWins
```

Use this when debugging one failing case without running the whole class.

---

### Run MULTIPLE challenges (several test classes)

Separate class names with commas (no spaces).

```powershell
.\mvnw.cmd test -Dtest=CarTest,LibraryBookTest,MovieTicketTest
```

```bash
./mvnw test -Dtest=CarTest,LibraryBookTest,MovieTicketTest
```

**Run all tests in one topic (wildcard):**

```powershell
# All classes & objects challenges
.\mvnw.cmd test -Dtest=com.chaicode.classesobjects.*Test

# All encapsulation challenges
.\mvnw.cmd test -Dtest=com.chaicode.encapsulation.*Test

# All interface challenges
.\mvnw.cmd test -Dtest=com.chaicode.interfaces.*Test
```

**Run multiple specific methods from the same class:**

```powershell
.\mvnw.cmd test -Dtest=CarTest#refuel+describe
```

---

### Quick reference — testing commands

| Goal | Command (Windows) |
|------|---------------------|
| Run **all** tests | `.\mvnw.cmd test` |
| Run **one challenge** | `.\mvnw.cmd test -Dtest=CarTest` |
| Run **one test case** | `.\mvnw.cmd test -Dtest=CarTest#describe` |
| Run **multiple challenges** | `.\mvnw.cmd test -Dtest=TestA,TestB,TestC` |
| Run **whole topic** | `.\mvnw.cmd test -Dtest=com.chaicode.classesobjects.*Test` |
| Compile only (no tests) | `.\mvnw.cmd compile` |
| Clean + full test run | `.\mvnw.cmd clean test` |

On Mac/Linux, replace `.\mvnw.cmd` with `./mvnw`.

---

### Run tests from your IDE

**VS Code**

1. Open a test file, e.g. `src/test/java/com/chaicode/classesobjects/CarTest.java`
2. Click **Run Test** above a `@Test` method (single case)
3. Click **Run Tests** above the class name (whole challenge)
4. Or open the **Testing** sidebar (flask icon) and run from there

**IntelliJ IDEA**

1. Open a test file
2. Green ▶ next to a method → run one test case
3. Green ▶ next to the class name → run all tests in that class
4. Right-click `src/test/java` → **Run 'All Tests'** for the full lab

---

## Topics covered

| Phase | Topic | Package | Challenges | Concepts |
|-------|-------|---------|------------|----------|
| 1 | Classes & Objects | `classesobjects` | 3 | Blueprint vs instance, object state, independent objects |
| 1 | Constructors | `constructors` | 3 | Default/parameterized constructors, overloading, validation |
| 1 | `this` Keyword | `thiskeyword` | 3 | Field shadowing, fluent builders, constructor chaining |
| 1 | Access Modifiers | `accessmodifiers` | 1 | `private`, getters, no password getter, reflection checks |
| 2 | Encapsulation | `encapsulation` | 3 | Data hiding, validation in setters, write-only PIN |
| 2 | Inheritance | `inheritance` | 2 | `extends`, `super`, method overriding, `instanceof` |
| 2 | Polymorphism | `polymorphism` | 2 | Parent reference / child object, overloading + overriding |
| 3 | `static` Keyword | `statickeyword` | 3 | Static fields/methods, static blocks, static nested classes |
| 3 | `final` Keyword | `finalkeyword` | 2 | `final` fields, constants, immutable-style objects |
| 4 | Interfaces | `interfaces` | 2 | Multiple interfaces, default/static/private methods |
| 4 | Enums | `enums` | 2 | Enum fields, constant-specific behaviour, state machines |
| 4 | Records | `records` | 2 | Compact constructors, immutability, custom methods |

---

## Suggested learning order

Work through the phases in order — each phase builds on the previous one.

### Phase 1 — Foundations

1. **Classes & Objects** → `Car.java`, `LibraryBook.java`, `MovieTicket.java`
2. **Constructors** → `StudentAdmission.java`, `PizzaOrder.java`, `GymMembership.java`
3. **`this` Keyword** → `EmailBuilder.java`, `CricketTeam.java`, `RoomBooking.java`
4. **Access Modifiers** → `UserAccount.java`

### Phase 2 — Core Pillars

5. **Encapsulation** → `ReportCard.java`, `DigitalWallet.java`, `EmployeeSalary.java`
6. **Inheritance** → `Vehicle.java` (+ `Bike`, `Truck`), `Employee.java` (+ `Manager`, `Intern`)
7. **Polymorphism** → `Payment.java` (+ payment types, `PaymentProcessor`), `Notifier.java` (+ `SmsNotifier`, `EmailNotifier`)

### Phase 3 — Intermediate OOP

8. **`static` Keyword** → `TicketCounter.java`, `UnitConverter.java`, `AppConfig.java`
9. **`final` Keyword** → `TaxRules.java`, `GpsLocation.java`

### Phase 4 — Modern & Practical OOP

10. **Interfaces** → `SmartHome.java` (+ `Switchable`, `Dimmable`, devices), `ShippingPartner.java` (+ courier partners)
11. **Enums** → `CoffeeSize.java`, `OrderStatus.java`
12. **Records** → `Money.java`, `TemperatureReading.java`

---

## Project structure

```
chaicode-java-oops-labs/
├── pom.xml
├── mvnw / mvnw.cmd
├── README.md
│
├── src/main/java/com/chaicode/
│   ├── classesobjects/     ← Phase 1: YOU EDIT THESE
│   ├── constructors/
│   ├── thiskeyword/
│   ├── accessmodifiers/
│   ├── encapsulation/      ← Phase 2
│   ├── inheritance/
│   ├── polymorphism/
│   ├── statickeyword/      ← Phase 3
│   ├── finalkeyword/
│   ├── interfaces/         ← Phase 4
│   ├── enums/
│   └── records/
│
└── src/test/java/com/chaicode/
    └── ...                 ← DO NOT EDIT (JUnit tests)
```

Some challenges include **supporting classes** in the same package (e.g. `Bike`, `Truck`, `UpiPayment`, `Switchable`). Read the Javadoc on the main challenge file — it tells you exactly which files to edit.

---

## How to solve a challenge

1. Open a challenge file (e.g. `src/main/java/com/chaicode/classesobjects/Car.java`)
2. Read the Javadoc at the top — it explains the story, rules, and expected behaviour
3. Replace `// Your code here` with your implementation
4. Run that challenge's tests:

```powershell
.\mvnw.cmd test -Dtest=CarTest
```

5. If one test fails, run just that case to debug:

```powershell
.\mvnw.cmd test -Dtest=CarTest#describe
```

6. When all tests in the class pass, move to the next challenge

**Tips for OOP challenges**

- Some tests use **reflection** to verify `private` fields, `static`/`final` modifiers, or that no getter exists — follow the Javadoc exactly
- When a challenge says "return a new object", mutating the original and returning `this` will fail
- For inheritance/polymorphism challenges, implement **all** related classes listed in the Javadoc (subclasses, interfaces, etc.)
- Record and enum challenges may require a **compact constructor** or **constant-specific method body** — check the rules in the Javadoc

---

## Challenge index

### Phase 1 — Foundations

| # | Class | Test class | Story |
|---|-------|------------|-------|
| 01 | `Car` | `CarTest` | ChaiRides fleet car rental |
| 02 | `LibraryBook` | `LibraryBookTest` | ChaiReads library borrowing |
| 03 | `MovieTicket` | `MovieTicketTest` | Starlight Cinema ticketing |
| 04 | `StudentAdmission` | `StudentAdmissionTest` | ChaiCode Academy admissions |
| 05 | `PizzaOrder` | `PizzaOrderTest` | Pizza Planet orders |
| 06 | `GymMembership` | `GymMembershipTest` | FitZone Gym memberships |
| 07 | `EmailBuilder` | `EmailBuilderTest` | ChaiMail fluent email builder |
| 08 | `CricketTeam` | `CricketTeamTest` | Gully Cricket League roster |
| 09 | `RoomBooking` | `RoomBookingTest` | StayEasy Hotels room booking |
| 10 | `UserAccount` | `UserAccountTest` | ChaiCode Login user account |

### Phase 2 — Core Pillars

| # | Class | Test class | Story |
|---|-------|------------|-------|
| 11 | `ReportCard` | `ReportCardTest` | St. Mary's report cards |
| 12 | `DigitalWallet` | `DigitalWalletTest` | ChaiPay digital wallet |
| 13 | `EmployeeSalary` | `EmployeeSalaryTest` | TechCorp payroll & PIN |
| 14 | `Vehicle` | `VehicleTest` | FleetGo delivery vehicles |
| 15 | `Employee` | `EmployeeTest` | TechCorp HR hierarchy |
| 16 | `Payment` | `PaymentTest` | ChaiKart checkout payments |
| 17 | `Notifier` | `NotifierTest` | PingMe notification service |

### Phase 3 — Intermediate OOP

| # | Class | Test class | Story |
|---|-------|------------|-------|
| 18 | `TicketCounter` | `TicketCounterTest` | Metro token machine |
| 19 | `UnitConverter` | `UnitConverterTest` | ChaiKitchen recipe converter |
| 20 | `AppConfig` | `AppConfigTest` | ChaiCode app settings |
| 21 | `TaxRules` | `TaxRulesTest` | KiranaKart GST calculator |
| 22 | `GpsLocation` | `GpsLocationTest` | ChaiRides GPS tracking |

### Phase 4 — Modern & Practical OOP

| # | Class | Test class | Story |
|---|-------|------------|-------|
| 23 | `SmartHome` | `SmartHomeTest` | ChaiHome smart automation |
| 24 | `ShippingPartner` | `ShippingPartnerTest` | ShopSwift courier partners |
| 25 | `CoffeeSize` | `CoffeeSizeTest` | Bean & Brew coffee sizes |
| 26 | `OrderStatus` | `OrderStatusTest` | Zippy order tracking |
| 27 | `Money` | `MoneyTest` | ChaiPay money record |
| 28 | `TemperatureReading` | `TemperatureReadingTest` | WeatherWise sensor readings |

---

## Troubleshooting

### `'java' is not recognized`

- Install JDK 17+ from [Adoptium](https://adoptium.net/)
- Set `JAVA_HOME` and add `%JAVA_HOME%\bin` to `Path`
- Restart terminal and IDE

### `'mvn' is not recognized`

You do **not** need global Maven. Always use:

```powershell
.\mvnw.cmd test
```

Not `mvn test`.

### PowerShell blocks `mvnw.cmd`

```powershell
Set-ExecutionPolicy -Scope CurrentUser RemoteSigned
```

Or use Command Prompt: `mvnw.cmd test`

### First run is slow or fails on network

- Check internet connection
- Retry: `.\mvnw.cmd test`
- Corporate proxy may require Maven proxy settings

### All tests fail with `expected X but was 0`, `was ""`, or `was false`

Normal before you write solutions. Implement the methods in the challenge file.

### `NullPointerException` in tests

Your method is still returning `null` (or a constructor body is empty). Finish the implementation — read which method the stack trace points to.

### `Expected IllegalArgumentException to be thrown, but nothing was thrown`

Your validation logic is missing. The Javadoc specifies exactly when to throw — add the check before updating state.

### Reflection test fails (`field is not private`, `method should be static`, etc.)

Some challenges require you to add access modifiers (`private`, `static`, `final`) or structure the class a certain way. The Javadoc calls these out explicitly — re-read the "Rules" section.

### VS Code does not show Run Test buttons

- Install **Extension Pack for Java**
- Reload: `Ctrl+Shift+P` → **Developer: Reload Window**
- Open the folder that contains `pom.xml`

### IntelliJ shows red errors but `mvnw test` works

**File → Invalidate Caches → Invalidate and Restart**, or right-click `pom.xml` → **Maven → Reload project**

### Test reports on disk

After a test run, detailed reports are in:

```
target/surefire-reports/
```

---

## Progress checklist

### Phase 1 — Foundations

**Classes & Objects**
- [ ] Car
- [ ] LibraryBook
- [ ] MovieTicket

**Constructors**
- [ ] StudentAdmission
- [ ] PizzaOrder
- [ ] GymMembership

**`this` Keyword**
- [ ] EmailBuilder
- [ ] CricketTeam
- [ ] RoomBooking

**Access Modifiers**
- [ ] UserAccount

### Phase 2 — Core Pillars

**Encapsulation**
- [ ] ReportCard
- [ ] DigitalWallet
- [ ] EmployeeSalary

**Inheritance**
- [ ] Vehicle (+ Bike, Truck)
- [ ] Employee (+ Manager, Intern)

**Polymorphism**
- [ ] Payment (+ UpiPayment, CardPayment, CashPayment, PaymentProcessor)
- [ ] Notifier (+ SmsNotifier, EmailNotifier)

### Phase 3 — Intermediate OOP

**`static` Keyword**
- [ ] TicketCounter
- [ ] UnitConverter
- [ ] AppConfig

**`final` Keyword**
- [ ] TaxRules
- [ ] GpsLocation

### Phase 4 — Modern & Practical OOP

**Interfaces**
- [ ] SmartHome (+ Switchable, Dimmable, SmartLight, SmartFan)
- [ ] ShippingPartner (+ BlueDartPartner, IndiaPostPartner)

**Enums**
- [ ] CoffeeSize
- [ ] OrderStatus

**Records**
- [ ] Money
- [ ] TemperatureReading

---

Good luck — start with `Car.java` and run `.\mvnw.cmd test -Dtest=CarTest`!
