public class SliceOHeaven {
    private String storeName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    private String[] storeMenu;
    private String[] pizzaIngredients;
    private double pizzaPrice;
    private String[] sides;
    private String[] drinks;
    private int orderID;
    private double orderTotal;

    public SliceOHeaven(String storeName, String storeAddress, String storeEmail, String storePhone) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeEmail = storeEmail;
        this.storePhone = storePhone;
        this.storeMenu = new String[]{};
        this.pizzaIngredients = new String[]{};
        this.pizzaPrice = 0.0;
        this.sides = new String[]{};
        this.drinks = new String[]{};
        this.orderID = 0;
        this.orderTotal = 0.0;
    }

    public void takeOrder(int orderID, String[] items, double[] prices) {
        this.orderID = orderID;
        this.orderTotal = 0.0;
        for (double price : prices) {
            this.orderTotal += price;
        }
    }

    public String makePizza(String pizzaType, String[] ingredients) {
        this.pizzaIngredients = ingredients;
        return pizzaType + " pizza with " + String.join(", ", ingredients) + " is being prepared.";
    }

    public void printReceipt(int orderID, String[] items, double[] prices) {
        System.out.println("Receipt for Order ID: " + orderID);
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%s: $%.2f\n", items[i], prices[i]);
        }
        System.out.printf("Total: $%.2f\n", this.orderTotal);
    }

    public static void main(String[] args) {
        SliceOHeaven pizzeria = new SliceOHeaven("Slice-o-Heaven", "123 Pizza Lane", "info@sliceoheaven.com", "555-1234");
        String[] orderItems = {"Margherita Pizza", "Garlic Bread"};
        double[] prices = {15.0, 5.0};
        pizzeria.takeOrder(1, orderItems, prices);
        System.out.println(pizzeria.makePizza("Margherita", new String[]{"Tomato", "Mozzarella", "Basil"}));
        pizzeria.printReceipt(1, orderItems, prices);
    }
}
