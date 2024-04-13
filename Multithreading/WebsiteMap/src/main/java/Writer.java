import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArraySet;

public class Writer {
    private final String path = "Data/website.txt";
    private String url = "";
    private CopyOnWriteArraySet<String> listLinks;

    public Writer(String url, CopyOnWriteArraySet<String> listLinks) {
        this.url = url;
        this.listLinks = listLinks;
        writeFile();
    }
    private void writeFile() {
        try {
            PrintWriter writer = new PrintWriter(path);
            StringBuilder result = new StringBuilder();
            result.append(url).append("\n");
            for (String link : listLinks) {
                String tab = java.lang.String.join("", Collections.nCopies(slashCounter(link) - slashCounter(url), "\t"));
                result.append(tab).append(link).append("\n");
            }
            writer.write(result.toString());
            writer.flush();
            writer.close();
            System.out.println("успешно");
        } catch (FileNotFoundException e) {
            System.out.println("exception: file not found");
        }
    }
    public int slashCounter(String link) {
        int slashCount = 0;
        for (int i = 0; i < link.length(); i++) {
            if (link.charAt(i) == '/') {
                slashCount++;
            }
        }
        return slashCount;
    }
}
