public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        container.addCount(12);
        System.out.println(container.getCount());

        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        for (int i=0; i<65536; i++) {
            char symbol = (char) i;
            if (alphabet.contains(String.valueOf(symbol))) {
                System.out.println(symbol + " - " + i);
            }
        }
    }
}
