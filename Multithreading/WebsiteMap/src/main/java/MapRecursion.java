import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MapRecursion extends RecursiveAction {

    private String url;

    public MapRecursion(String url) {
        this.url = url;
    }
    @SneakyThrows
    @Override
    protected void compute() {

        Thread.sleep(150);

        ParseHtml parseHtml = new ParseHtml();
        List<String> childList = parseHtml.parseChild(url);
        List<MapRecursion> taskList = new ArrayList<>();

        for (String child : childList) {
            MapRecursion task = new MapRecursion(child);
            task.fork();
            taskList.add(task);
        }
        for (MapRecursion task : taskList) {
            task.join();
        }
    }
}
