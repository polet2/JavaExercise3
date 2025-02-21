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

    public String printReceipt() {
        return "Order ID: " + orderID + "\n" +
               "Pizza Ingredients: " + String.join(", ", pizzaIngredients) + "\n" +
               "Sides: " + String.join(", ", sides) + "\n" +
               "Drinks: " + String.join(", ", drinks) + "\n" +
               "Order Total: $" + String.format("%.2f", orderTotal) + "\n" +
               "Thank you for ordering from " + storeName + "!";
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
        System.out.println(pizzeria.printReceipt());
    }
}