import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectorySearch {

    static void search(String directory) {
        try {
            Stream<Path> stream = Files.find(Paths.get(directory), 12,
                    ((path, basicFileAttributes) -> {
                File file = path.toFile();
                return !file.isDirectory() &
                        (file.getName().endsWith(".csv") | file.getName().endsWith(".json"));
            }));
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Directory not found");
        }
    }
}
