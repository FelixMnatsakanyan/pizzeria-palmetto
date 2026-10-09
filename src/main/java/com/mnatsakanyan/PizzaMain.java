package main.java.Pizzeria.src.main.java.com.mnatsakanyan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaMain {
    public static void main(String[] args) {
        PizzaOrder myOrder = new PizzaOrder(10001, 7717, "12:40");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter your ID:");
            int orderedId = Integer.parseInt(reader.readLine());

            System.out.println("Enter your phone:");
            int phone = Integer.parseInt(reader.readLine());

            System.out.println("Enter your time:");
            String time = reader.readLine();

            PizzaOrder pizzaOrder = new PizzaOrder(orderedId, phone, time);

            for (int i = 1; i <= 10; i++) {
                System.out.println("--- Pizza #" + i + "---");
                System.out.println("Enter your pizza name:");
                String pizzaName = reader.readLine();

                System.out.println("Enter your pizza type:");
                PizzaType pizzaType = PizzaType.valueOf(reader.readLine().toUpperCase());

                System.out.println("Enter quantity:");
                int quantity = Integer.parseInt(reader.readLine());

                Pizza pizza = new Pizza(pizzaName, pizzaType, quantity, 1);

                System.out.println("Enter ingredient:");
                Ingredient ingredientInput = Ingredient.valueOf(reader.readLine().toUpperCase());
                pizza.addIngredient(ingredientInput);
                pizzaOrder.addPizza(pizza);
        }
            pizzaOrder.printCheck();

        } catch (IOException e) {
            throw new RuntimeException();
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

}
}
