import java.util.List;

public class SliceOHeaven {
    private String storeName;
    @SuppressWarnings("unused")
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    private List<String> storeMenu;
    private List<String> pizzaIngredients;
    private double pizzaPrice;
    private List<String> sides;
    private List<String> drinks;
    private int orderID;
    private double orderTotal;
    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

    public Pizzeria() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "Garlic Bread";
        this.drinks = "Coke";
    }

    public Pizzeria(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = "Garlic Bread";
        this.drinks = "Coke";
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public SliceOHeaven(String storeName, String storeAddress, String storeEmail, String storePhone, List<String> storeMenu) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeEmail = storeEmail;
        this.storePhone = storePhone;
        this.storeMenu = storeMenu;
        this.orderID = 0;
        this.orderTotal = 0.0;
    }
    public void takeOrder(List<String> pizzaIngredients, List<String> sides, List<String> drinks) {
        this.pizzaIngredients = pizzaIngredients;
        this.sides = sides;
        this.drinks = drinks;
        this.orderID++;
        this.orderTotal = calculateOrderTotal();
    }
    public String makePizza() {
        return "Making pizza with ingredients: " + String.join(", ", pizzaIngredients);
    }

    private void printReceipt() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: $" + orderTotal);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
    }

    public void showReceipt() {
        printReceipt();
    }
    
    private double calculateOrderTotal() {
        // Assuming a fixed price for simplicity
        double pizzaPrice = 15.0;
        double sidesPrice = sides.size() * 5.0;
        double drinksPrice = drinks.size() * 2.0;
        return pizzaPrice + sidesPrice + drinksPrice;
    }

    public static void main(String[] args) {
        List<String> storeMenu = List.of("Margherita", "Pepperoni", "Veggie");
        SliceOHeaven pizzeria = new SliceOHeaven("Slice-o-Heaven", "123 Pizza St.", "contact@sliceoheaven.com", "123-456-7890", storeMenu);

        pizzeria.takeOrder(List.of("Cheese", "Tomato", "Basil"), List.of("Garlic Bread"), List.of("Coke"));
        System.out.println(pizzeria.makePizza());
        System.out.println(pizzeria.showReceipt());
    }
}