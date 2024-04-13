import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String url = "https://archeage.ru/";

        MapRecursion recursion = new MapRecursion(url);
        new ForkJoinPool().invoke(recursion);
        Writer writer = new Writer(url, ParseHtml.listLinks);
    }
}
