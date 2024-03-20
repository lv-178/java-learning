import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class JsonToObject {

    static ArrayList<MetroStation> convert(String directory) {
        ArrayList<MetroStation> stations = new ArrayList<>();
        try {
            String file = Files.readString(Path.of(directory));
            JSONParser parser = new JSONParser();
            JSONArray stationsList = (JSONArray) parser.parse(file);
            stationsList.forEach(line -> {
                JSONObject object = (JSONObject) line;
                String name = (String) object.get("station_name");
                String depth = (String) object.get("depth");
                stations.add(new MetroStation(name, depth));
            });
        } catch (Exception e) {
            System.out.println("error");
        }
        return stations;
    }
}
