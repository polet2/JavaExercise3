public class SliceOHeaven {
    private String storeName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    private String storeMenu;
    private String pizzaIngredients;
    private double pizzaPrice;
    private String sides;
    private String drinks;
    private String orderID;
    private double orderTotal;

    private final String DEF_ORDER_ID = "DEF-SOH-099";
    private final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private final double DEF_ORDER_TOTAL = 15.00;

    public SliceOHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "Garlic Bread";
        this.drinks = "Coke";
    }

    public SliceOHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
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

    public void takeOrder() {
        System.out.println("Order taken successfully!");
    }

    public void makePizza() {
        System.out.println("Pizza is being made with ingredients: " + pizzaIngredients);
    }

    private void printReceipt() {
        System.out.println("Receipt for Order ID: " + orderID);
        System.out.println("Total Amount: $" + orderTotal);
    }

    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        System.out.println("First digit of the card: " + firstCardDigit);

        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Last four digits of the card: " + lastFourDigits);

        String cardNumberToDisplay = cardNumber.charAt(0) +
                                    "*".repeat(cardNumber.length() - 5) +
                                    cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, double specialPrice) {
        StringBuilder special = new StringBuilder();
        special.append("Today's Special:\n");
        special.append("Pizza: ").append(pizzaOfTheDay).append("\n");
        special.append("Side: ").append(sideOfTheDay).append("\n");
        special.append("Special Price: $").append(specialPrice).append("\n");
        System.out.println(special.toString());
    }

    public static void main(String[] args) {
        SliceOHeaven pizzaOrder = new SliceOHeaven();
        pizzaOrder.takeOrder();
        pizzaOrder.makePizza();
        pizzaOrder.printReceipt();

        pizzaOrder.processCardPayment("12345678901234", "12/25", 123);
        pizzaOrder.specialOfTheDay("Pepperoni Pizza", "Garlic Bread", 12.99);
    }
}