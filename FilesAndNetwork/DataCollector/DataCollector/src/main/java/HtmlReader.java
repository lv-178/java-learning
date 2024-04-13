import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.List;

import java.io.IOException;
import java.util.ArrayList;

public class HtmlReader {

    Document doc;
    List<MetroLine> metroLines = new ArrayList<>();
    List<MetroStation> metroStations = new ArrayList<>();

    public HtmlReader() {
    }

    public void reader(String url) {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Page not found");
        }
    }

    public void search() {
        Elements lines = doc.select("div.js-toggle-depend");
        Elements linesWithStations = doc.select("div.js-depend");

        lines.forEach(line -> {
            int i = line.toString().indexOf("data-line=\"") + 11;
            int end = line.toString().indexOf("\"", i);
            String lineNumber = line.toString().substring(i, end);
            metroLines.add(new MetroLine(line.text(), lineNumber));

            int i2 = linesWithStations.toString().indexOf("data-line=\"" + lineNumber);
            int end2 = linesWithStations.toString().indexOf("</div>", i2);
            String thisLine = linesWithStations.toString().substring(i2, end2);

            String[] stationWithOtherText = thisLine.split("</p>");
            for (int k = 0; k < stationWithOtherText.length - 1; k++) {
                int i3 = stationWithOtherText[k].indexOf("name\">") + 6;
                int end3 = stationWithOtherText[k].indexOf("<", i3);
                String stationName = stationWithOtherText[k].substring(i3, end3);
                metroStations.add(new MetroStation(stationName, lineNumber));
            }
        });
    }
}
