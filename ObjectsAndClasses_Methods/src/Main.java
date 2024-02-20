public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Молоко, 1 л", 40);
        basket.add("Яйца, десяток", 120, 3);
        basket.add("Мука, 2 кг", 135, 4, 2);
        basket.print("Ваша корзина:");
        System.out.println("Общий вес " + basket.getTotalWeight() + " кг");
        System.out.println("Общая стоимость " + basket.getTotalPrice() + " рублей");
    }
}