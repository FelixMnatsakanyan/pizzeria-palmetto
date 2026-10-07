package main.java.Pizzeria;

public class Pizza {
    private String name;
    private PizzaType type;
    private int quantity;
    private Ingredient[] ingredients;
    private int ingredientsCount = 0;

    public Pizza(String name, PizzaType type, int quantity, int index) {
        if(name == null || name.length() < 4 || name.length() > 20 || !name.matches("^[a-zA-Z]+$")) {
            this.name = "customer_name_" + index;
        } else {
            this.name = name;
        }

        if(quantity <= 0) {
            this.quantity = 1;
        } else {
            this.quantity = quantity;
        }

        if(type == null) {
            this.type = PizzaType.CALZONE;
        } else {
            this.type = type;
        }
        this.ingredients = new Ingredient[10];
    }

    public void addIngredient(Ingredient ingredient) {
        if(ingredient == null) {
            return;
        }
        if(ingredientsCount <  ingredients.length) {
            for (int i = 0; i < ingredientsCount; i++) {
                if(ingredients[i].equals(ingredient)) {
                    System.out.println("It's a Duplicate");
                    return;
                }
            }

            ingredients[ingredientsCount] = ingredient;
            ingredientsCount++;
        } else {
            System.out.println("No space");
        }
    }

    public double getPriceByName() {
        if(this.type.equals(PizzaType.CALZONE)) {
            return 1.5;
        }
        return 1.0;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public PizzaType getType() {
        return this.type;
    }

    public Ingredient[] getIngredients() {
        Ingredient[] ingredientsCopy = ingredients;
        return ingredientsCopy;
    }

    public int getIngredienceCount() {
        return this.ingredientsCount;
    }

}
