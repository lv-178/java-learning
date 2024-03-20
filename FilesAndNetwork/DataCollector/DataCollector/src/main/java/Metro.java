import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Getter
public class Metro {

    TreeMap<String, String> stations = new TreeMap<>();
    List<MetroLine> lines = new ArrayList<>();

    public Metro() {
    }

    public void metroToObject(List<MetroLine> linesList, List<MetroStation> stationsList) {
        linesList.forEach(line -> {
            stations.put(line.getName(), "");
            stationsList.forEach(station -> {
                if (!line.getName().contains(station.getNumber()) & line.getNumber().equals(station.getNumber())) {
                    stations.put(line.getName(),
                            stations.get(line.getName()) + ", \"" + station.getName() + "\"\n");
                }
            });
        });
        lines = linesList;
    }
}
