import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Stations {

    public ArrayList<MetroStation2> stations = new ArrayList<>();

    public void stationsToObject(List<MetroLine> linesList, List<MetroStation> stationsList,
                                 ArrayList<MetroStation> depthList,
                                 ArrayList<MetroStation> dateList) {
        TreeMap<String, String> depthMap = new TreeMap<>();
        depthList.forEach(station -> {
            depthMap.put(station.getName(), station.getNumber());
        });
        TreeMap<String, String> dateMap = new TreeMap<>();
        dateList.forEach(station -> {
            dateMap.put(station.getName(), station.getNumber());
        });
        TreeMap<String, String> linesMap = new TreeMap<>();
        linesList.forEach(line -> {
            linesMap.put(line.getNumber(), line.getName());
        });

        stationsList.forEach(station -> {
            String name = station.getName();
            String number = station.getNumber();
            String lineName = linesMap.get(number);
            String date = dateMap.get(name);
            String depth = depthMap.get(name);
            stations.add(new MetroStation2(name, lineName, date, depth));
        });
    }
}
