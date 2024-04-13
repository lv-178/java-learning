import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class ParseHtml {

    public static CopyOnWriteArraySet<String> listLinks = new CopyOnWriteArraySet<>();

    public List<String> parseChild(String url) throws Exception {

        List<String> childList = new ArrayList<>();
        Connection connection = Jsoup.connect(url).timeout(0).ignoreHttpErrors(true)
                .ignoreContentType(true).referrer(url).followRedirects(false);

        Document doc = connection.get();
        Elements links = doc.select("a");
        for (Element element : links) {
            String href = element.attr("abs:href");
            if (href.startsWith(url) & !href.contains("#") & !listLinks.contains(href) & !href.contains(".pdf")) {
                if (!href.endsWith("/")) {
                    href += "/";
                }
                listLinks.add(href);
                childList.add(href);
            }
        }
        return childList;
    }
}
