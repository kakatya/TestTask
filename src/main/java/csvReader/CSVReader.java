package csvReader;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.stream.Stream;

public class CSVReader {

    public static void readCsv(String path) {
        File file = new File(path);

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fileReader);
            long beforeTime =System.currentTimeMillis();
            reader.lines().filter(line -> {
                return line.split(",")[1].startsWith("\"Bo");
            }).forEach(System.out::println);
            System.out.println(System.currentTimeMillis()-beforeTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
