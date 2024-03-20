public class Main {
    public static void main(String[] args) {
        HtmlReader html = new HtmlReader();
        html.reader("https://skillbox-java.github.io/");
        html.search();
//        html.metroLines.forEach(System.out::println);
//        html.metroStations.forEach(System.out::println);
//
//        DirectorySearch.search("data");
//
//        JsonToObject.convert("data/7/1/depths-2.json").forEach(System.out::println);
//        JsonToObject.convert("data/2/4/depths-1.json").forEach(System.out::println);
//        JsonToObject.convert("data/4/6/depths-3.json").forEach(System.out::println);
//
//        CsvToObject.convert("data/9/6/dates-3.csv").forEach(System.out::println);
//        CsvToObject.convert("data/4/6/dates-1.csv").forEach(System.out::println);
//        CsvToObject.convert("data/0/5/dates-2.csv").forEach(System.out::println);

        Metro metro = new Metro();
        metro.metroToObject(html.metroLines, html.metroStations);
        ToJson.convert(metro, "data/metro.json");

        Stations stations = new Stations();
        stations.stationsToObject(html.metroLines, html.metroStations,
                JsonToObject.convert("data/7/1/depths-2.json"),
                CsvToObject.convert("data/9/6/dates-3.csv"));
        ToJson.convert(stations, "data/stations.json");
    }
}
