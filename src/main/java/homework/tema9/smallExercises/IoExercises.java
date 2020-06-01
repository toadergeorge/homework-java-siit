package homework.tema9.smallExercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class IoExercises {

    public static void main(String[] args) {

        IoExercises service = new IoExercises();

        try {
            String xx = service.getPathElements("files");
            System.out.println("service = " + xx);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getPathElements(String path) throws IOException {

        if(path.equals("")){
            return "";
        }
        ArrayList<String> result = new ArrayList<String>();

        Files.walk(Paths.get(path), 1)
                .map(Path::normalize)
                .forEach(fileName -> result.add(fileName.toString()));

        return result.toString();
    }





}
