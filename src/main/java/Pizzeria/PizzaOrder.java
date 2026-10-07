package main.java.Pizzeria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PizzaOrder {
    private int orderNumber;
    private int clientNumber;
    private String orderTime;
    private Pizza[] pizzas;
    private int pizzaCount = 0;

    public PizzaOrder(int orderNumber, int clientNumber, String orderTime) {
        this.clientNumber = clientNumber;
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.pizzas = new Pizza[10];
    }

    public void addPizza(Pizza pizza) {
        if(pizza == null) {
            throw new NullPointerException();
        }

        if(pizzaCount < pizzas.length) {
            pizzas[pizzaCount] = pizza;
            pizzaCount++;
        }
    }

    public void printCheck() {
        try(PrintWriter writer = new PrintWriter(new FileWriter("receipt.txt"))) {
            writer.println("********************************");
            writer.println("Order: " + this.orderNumber);
            writer.println("Client: " + this.clientNumber);

            double sum = 0.0;

            for (int i = 0; i < pizzaCount; i++) {
                Pizza currentPizza = pizzas[i];

                writer.println("Name: " + currentPizza.getName());
                writer.println("--------------------------------");

                double pizzaPrice = 0.0;

                if(currentPizza.getType().equals("Calzone")) {
                    pizzaPrice += 1.5;
                    writer.println("Pizza Base (Calzone) 1,50 €");
                } else {
                    pizzaPrice += 1.0;
                    writer.println("Pizza Base (Regular) 1,00 €");
                }

                Ingredient[] ingredienceArr = currentPizza.getIngredients();
                for(int j = 0; j < currentPizza.getIngredienceCount(); j++) {
                    Ingredient ingredient = ingredienceArr[j];
                    double price = Ingredient.valueOf(String.valueOf(ingredient)).getPrice();
                    pizzaPrice += price;
                    writer.println(ingredient + " " + String.format("%.2f", price) + " €");
                }

                double currentPizzaAmount = pizzaPrice * currentPizza.getQuantity();
                sum += currentPizzaAmount;

                writer.println("--------------------------------");
                writer.println("Amount: " + String.format("%.2f", currentPizzaAmount) + " €");
                writer.println("Quantity: " + currentPizza.getQuantity());
                writer.println("--------------------------------");
            }

            writer.println("Total amount: " + sum + " €");
            writer.println("********************************");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printOrder() {
        for(int i = 0; i < pizzaCount; i++) {
            System.out.println("[" + this.orderNumber + " : " + this.clientNumber + " : " + pizzas[i].getName() + " : " + pizzas[i].getQuantity() + "]");
        }
    }
}
