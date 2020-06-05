package homework.tema9.smallExercises;

import org.apache.commons.io.FilenameUtils;

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
//            String xx = service.getPathElements("files");
//            System.out.println("service = " + xx);

            String xx = service.getFilesByExtensionFromPath("txt","files");
            System.out.println("service = " + xx);
            


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getPathElements(String path) throws IOException {

        /* 1. Implement a method to get a list of all file/directory names from the given. */
        if(path.equals("")){
            return "";
        }
        ArrayList<String> result = new ArrayList<String>();

        Files.walk(Paths.get(path), 1)
                .map(Path::normalize)
                .forEach(fileName -> result.add(fileName.toString()));

        return result.toString();
    }

    public String getFilesByExtensionFromPath(String filesExtension, String filesPath) throws IOException {
        /*2. Implement a method to get specific files by extensions from a specified folder.*/
        if(filesExtension.equals("") || filesPath.equals("")){
            return "";
        }

        ArrayList<String> result = new ArrayList<String>();

        Files.walk(Paths.get(filesPath), 1)
                .map(Path::normalize)
                .forEach(file -> {

                    String fileExtension= FilenameUtils.getExtension(file.toFile().getName());


                    System.out.println("fttttttttttttt = " + fileExtension);
                    if(file.endsWith(filesExtension) ){
                        result.add(file.toString());
                    }
                });

        if(result.toArray().length == 0){
            return "";
        }

        return result.toString();
    }





}
