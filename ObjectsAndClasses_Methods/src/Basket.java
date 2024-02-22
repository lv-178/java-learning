public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int priceInAllBuskets = 0;
    private static int countInAllBuskets = 0;
    public static int numberOfBuskets = 0;

    public Basket() {
        numberOfBuskets++;
        items = "";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        totalWeight = totalWeight + weight * count;
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " рублей";
        totalPrice = totalPrice + count * price;
        addToPriceInAllBuskets(count, price);
        addToCountInAllBuskets(count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    private static void addToPriceInAllBuskets(int count, int price) {
        priceInAllBuskets += count * price;
    }

    private static void addToCountInAllBuskets(int count) {
        countInAllBuskets += count;
    }

    public static int getCountInAllBuskets() {
        return countInAllBuskets;
    }

    public static int getPriceInAllBuskets() {
        return priceInAllBuskets;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public static double averageProductPrice() {
        return priceInAllBuskets / countInAllBuskets;
    }

    public static double averageBasketPrice() {
        return priceInAllBuskets / numberOfBuskets;
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}