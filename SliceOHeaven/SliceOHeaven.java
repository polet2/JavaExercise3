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

    private static final double PIZZA_BASE_PRICE = 10.0;
    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;

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
        int orderCount = 0;
        while (true) {
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
            for (PizzaSelection pizza : PizzaSelection.values()) {
                System.out.println((pizza.ordinal() + 1) + ". " + pizza.toString());
            }
            System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose");
            System.out.print("Please enter your choice (1 - 6): ");
            int pizzaChoice = scanner.nextInt();

            if (pizzaChoice < 1 || pizzaChoice > 6) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            if (pizzaChoice == 6) {
                System.out.println("Please choose up to 10 toppings:");
                for (PizzaToppings topping : PizzaToppings.values()) {
                    System.out.println((topping.ordinal() + 1) + ". " + topping.toString());
                }
                System.out.print("Enter your choices separated by spaces: ");
                scanner.nextLine(); // Consume newline
                String[] toppingsChoices = scanner.nextLine().split(" ");
                StringBuilder customPizza = new StringBuilder("Custom Pizza with ");
                double customPrice = PIZZA_BASE_PRICE;
                for (String choice : toppingsChoices) {
                    int index = Integer.parseInt(choice) - 1;
                    customPizza.append(PizzaToppings.values()[index].getTopping()).append(", ");
                    customPrice += PizzaToppings.values()[index].getToppingPrice();
                }
                customPizza.append("for €").append(customPrice);
                pizzasOrdered[orderCount] = customPizza.toString();
                totalOrderPrice += customPrice;
            } else {
                PizzaSelection selectedPizza = PizzaSelection.values()[pizzaChoice - 1];
                pizzasOrdered[orderCount] = selectedPizza.toString();
                totalOrderPrice += selectedPizza.getPrice();
            }

            System.out.println("What size should your pizza be?");
            for (PizzaSize size : PizzaSize.values()) {
                System.out.println((size.ordinal() + 1) + ". " + size.toString());
            }
            System.out.print("Enter your choice: ");
            int sizeChoice = scanner.nextInt();
            PizzaSize selectedSize = PizzaSize.values()[sizeChoice - 1];
            pizzaSizesOrdered[orderCount] = selectedSize.toString();
            totalOrderPrice += selectedSize.getAddToPizzaPrice();

            System.out.println("Choose a side dish:");
            for (SideDish side : SideDish.values()) {
                System.out.println((side.ordinal() + 1) + ". " + side.toString());
            }
            System.out.print("Enter your choice: ");
            int sideChoice = scanner.nextInt();
            SideDish selectedSide = SideDish.values()[sideChoice - 1];
            sideDishesOrdered[orderCount] = selectedSide.toString();
            totalOrderPrice += selectedSide.getAddToPizzaPrice();

            System.out.println("Choose a drink:");
            for (Drinks drink : Drinks.values()) {
                System.out.println((drink.ordinal() + 1) + ". " + drink.toString());
            }
            System.out.print("Enter your choice: ");
            int drinkChoice = scanner.nextInt();
            Drinks selectedDrink = Drinks.values()[drinkChoice - 1];
            drinksOrdered[orderCount] = selectedDrink.toString();
            totalOrderPrice += selectedDrink.getAddToPizzaPrice();

            orderCount++;
            System.out.print("Do you want to order more? (Y/N): ");
            String moreOrders = scanner.next();
            if (moreOrders.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");
        for (int i = 0; i < pizzasOrdered.length && pizzasOrdered[i] != null; i++) {
            orderDetails.append((i + 1) + ". " + pizzasOrdered[i] + "\n")
                        .append(pizzaSizesOrdered[i] + "\n")
                        .append(sideDishesOrdered[i] + "\n")
                        .append(drinksOrdered[i] + "\n");
        }
        orderDetails.append("ORDER TOTAL: €").append(totalOrderPrice);
        return orderDetails.toString();
    }

    public enum PizzaSelection {
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

        private final String pizzaName;
        private final String pizzaToppings;
        private final double price;

        PizzaSelection(String pizzaName, String pizzaToppings, double price) {
            this.pizzaName = pizzaName;
            this.pizzaToppings = pizzaToppings;
            this.price = price;
        }

        public String getPizzaName() {
            return pizzaName;
        }

        public String getPizzaToppings() {
            return pizzaToppings;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
        }
    }

    public enum PizzaToppings {
        HAM("Ham", 2),
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2),
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5),
        TOMATOES("Tomatoes", 0.4),
        GREEN_PEPPER("Green Pepper", 0.5),
        BLACK_OLIVES("Black Olives", 0.5),
        SPINACH("Spinach", 0.5),
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8),
        FETA_CHEESE("Feta Cheese", 1),
        PARMESAN_CHEESE("Parmesan Cheese", 1);

        private final String topping;
        private final double toppingPrice;

        PizzaToppings(String topping, double toppingPrice) {
            this.topping = topping;
            this.toppingPrice = toppingPrice;
        }

        public String getTopping() {
            return topping;
        }

        public double getToppingPrice() {
            return toppingPrice;
        }

        @Override
        public String toString() {
            return topping + " for €" + toppingPrice;
        }
    }

    public enum PizzaSize {
        LARGE("Large", 10),
        MEDIUM("Medium", 5),
        SMALL("Small", 0);

        private final String pizzaSize;
        private final double addToPizzaPrice;

        PizzaSize(String pizzaSize, double addToPizzaPrice) {
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getPizzaSize() {
            return pizzaSize;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return pizzaSize + ": €" + addToPizzaPrice;
        }
    }

    public enum SideDish {
        CALZONE("Calzone", 15),
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);

        private final String sideDishName;
        private final double addToPizzaPrice;

        SideDish(String sideDishName, double addToPizzaPrice) {
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getSideDishName() {
            return sideDishName;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return sideDishName + ": €" + addToPizzaPrice;
        }
    }

    public enum Drinks {
        COCA_COLA("Coca Cola", 8),
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);

        private final String drinkName;
        private final double addToPizzaPrice;

        Drinks(String drinkName, double addToPizzaPrice) {
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getDrinkName() {
            return drinkName;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return drinkName + ": €" + addToPizzaPrice;
        }
    }
    public static void main(String[] args) {
        SliceOHeaven pizzaOrder = new SliceOHeaven();
        pizzaOrder.takeOrder();
        System.out.println(pizzaOrder);
    }
}