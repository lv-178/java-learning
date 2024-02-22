public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Молоко, 1 л", 40);
        basket1.add("Яйца, десяток", 120, 3);
        basket1.add("Мука, 2 кг", 135, 4, 2);

        Basket basket2 = new Basket();
        basket2.add("Кефир", 79, 1);
        basket2.add("Печенье", 30, 3);

        basket1.print("Корзина 1:");
        System.out.println("Общий вес " + basket1.getTotalWeight() + " кг");
        System.out.println("Общая стоимость " + basket1.getTotalPrice() + " рублей");
        basket2.print("\nКорзина 2:");
        System.out.println("Общий вес " + basket2.getTotalWeight() + " кг");
        System.out.println("Общая стоимость " + basket2.getTotalPrice() + " рублей");

        System.out.println("\nОбщее количество товаров во всех корзинах: " + Basket.getCountInAllBuskets());
        System.out.println("Общая стоимость товаров во всех корзинах: " + Basket.getPriceInAllBuskets());
        System.out.println("Всего корзин: " + Basket.numberOfBuskets);
        System.out.println("Средняя цена товара во всех корзинах: " + Basket.averageProductPrice());
        System.out.println("Средняя стоимость одной корзины: " + Basket.averageBasketPrice());
    }
}