# 🍕 Pizzeria Palmetto

A console-based pizza ordering application developed in **Java 21** using **Maven**. This project implements professional object-oriented design and input validation.

---

## 🚀 Features

* **Flexible Order Management:** Create and manage pizza orders with validation for customer IDs, phone numbers, and delivery times.
* **Customizable Pizzas:** Choose from multiple pizza types (`CALZONE` vs `REGULAR`), control quantities (up to 10 pizzas per order), and add custom ingredients.
* **Robust Input Handling:** Case-insensitive input sanitization (`toUpperCase()`, `trim()`) and graceful exception management for invalid entries.
* **Interactive CLI:** Simple command-line interface with a built-in exit option (`exit`) for smooth order entry.

---

## 🛠️ Tech Stack

* **Language:** Java 21
* **Build Tool:** Apache Maven
* **VCS:** Git & GitHub

---

## 📂 Project Structure

```text
pizzeria-palmetto/
├── src/
│   └── main/
│       └── java/
│           └── Pizzeria/
│               ├── PizzaMain.java      # Main entry point & CLI logic
│               ├── PizzaOrder.java     # Order management & check printing
│               ├── Pizza.java          # Pizza domain model & ingredients
│               ├── PizzaType.java      # Enum for pizza styles
│               └── Ingredient.java     # Enum for available toppings
├── pom.xml                             # Maven configuration
└── README.md                           # Project documentation