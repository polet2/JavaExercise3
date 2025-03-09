import java.util.Scanner;

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
    private final String BLACKLISTED_NUMBER = "12345678901234";

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
        Scanner scanner = new Scanner(System.in);
        int ingChoice1, ingChoice2, ingChoice3;
        String ing1 = "", ing2 = "", ing3 = "";
        int sizeChoice;
        String pizzaSize = "";
        String extraCheese;
        int sideDishChoice;
        String sideDish = "";
        int drinkChoice;
        String drink = "";

        while (true) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom\n2. Paprika\n3. Sun-dried tomatoes\n4. Chicken\n5. Pineapple");
            System.out.print("Enter any three choices (1, 2, 3,…) separated by spaces: ");
            ingChoice1 = scanner.nextInt();
            ingChoice2 = scanner.nextInt();
            ingChoice3 = scanner.nextInt();

            if (ingChoice1 < 1 || ingChoice1 > 5 || ingChoice2 < 1 || ingChoice2 > 5 || ingChoice3 < 1 || ingChoice3 > 5) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                continue;
            }

            ing1 = getIngredient(ingChoice1);
            ing2 = getIngredient(ingChoice2);
            ing3 = getIngredient(ingChoice3);
            break;
        }

        while (true) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large\n2. Medium\n3. Small");
            System.out.print("Enter only one choice (1, 2, or 3): ");
            sizeChoice = scanner.nextInt();

            if (sizeChoice < 1 || sizeChoice > 3) {
                System.out.println("Invalid choice. Please enter a valid choice.");
                continue;
            }

            pizzaSize = getPizzaSize(sizeChoice);
            break;
        }

        System.out.print("Do you want extra cheese (Y/N): ");
        extraCheese = scanner.next();

        while (true) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone\n2. Garlic bread\n3. Chicken puff\n4. Muffin\n5. Nothing for me");
            System.out.print("What would you like? Pick one (1, 2, 3,…): ");
            sideDishChoice = scanner.nextInt();

            if (sideDishChoice < 1 || sideDishChoice > 5) {
                System.out.println("Invalid choice. Please enter a valid choice.");
                continue;
            }

            sideDish = getSideDish(sideDishChoice);
            break;
        }

        while (true) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola\n2. Cold coffee\n3. Cocoa Drink\n4. No drinks for me");
            System.out.print("Enter your choice: ");
            drinkChoice = scanner.nextInt();

            if (drinkChoice < 1 || drinkChoice > 4) {
                System.out.println("Invalid choice. Please enter a valid choice.");
                continue;
            }

            drink = getDrink(drinkChoice);
            break;
        }

        System.out.println("Order taken successfully!");
    }

    private String getIngredient(int choice) {
        switch (choice) {
            case 1: return "Mushroom";
            case 2: return "Paprika";
            case 3: return "Sun-dried tomatoes";
            case 4: return "Chicken";
            case 5: return "Pineapple";
            default: return "";
        }
    }

    private String getPizzaSize(int choice) {
        switch (choice) {
            case 1: return "Large";
            case 2: return "Medium";
            case 3: return "Small";
            default: return "";
        }
    }

    private String getSideDish(int choice) {
        switch (choice) {
            case 1: return "Calzone";
            case 2: return "Garlic bread";
            case 3: return "Chicken puff";
            case 4: return "Muffin";
            case 5: return "Nothing for me";
            default: return "";
        }
    }

    private String getDrink(int choice) {
        switch (choice) {
            case 1: return "Coca Cola";
            case 2: return "Cold coffee";
            case 3: return "Cocoa Drink";
            case 4: return "No drinks for me";
            default: return "";
        }
    }

    public void makePizza() {
        System.out.println("Pizza is being made with ingredients: " + pizzaIngredients);
    }

    @Override
    public String toString() {
        return "Receipt for Order ID: " + orderID + "\n" +
               "Pizza Ingredients: " + pizzaIngredients + "\n" +
               "Total Amount: $" + orderTotal;
    }

    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (cardNumber.length() != 14) {
                System.out.println("Invalid card number length. Please enter a 14-digit card number:");
                cardNumber = scanner.next();
                continue;
            }

            if (cardNumber.equals(BLACKLISTED_NUMBER)) {
                System.out.println("Card is blacklisted. Please use another card:");
                cardNumber = scanner.next();
                continue;
            }

            break;
        }

        System.out.println("Card accepted");
        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        System.out.println("First digit of the card: " + firstCardDigit);

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
        System.out.println(pizzaOrder);
        pizzaOrder.processCardPayment("12345678901234", "12/25", 123);
        pizzaOrder.specialOfTheDay("Pepperoni Pizza", "Garlic Bread", 12.99);
    }
}