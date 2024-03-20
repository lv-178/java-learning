import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;

public class ToJson {

    static void convert(Object object, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String newJson = objectMapper.writeValueAsString(object);
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(newJson);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            System.out.println("processing exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
