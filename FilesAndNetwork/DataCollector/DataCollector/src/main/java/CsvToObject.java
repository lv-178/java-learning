import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvToObject {

    static ArrayList<MetroStation> convert(String directory) {
        ArrayList<MetroStation> stations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(directory));
            lines.forEach(line -> {
                String[] info = line.split(",");
                stations.add(new MetroStation(info[0], info[1]));
            });
        } catch (Exception e) {
            System.out.println("error");
        }
        return stations;
    }
}
