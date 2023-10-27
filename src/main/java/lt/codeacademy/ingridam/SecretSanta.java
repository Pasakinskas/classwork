package lt.codeacademy.ingridam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SecretSanta {

    public static List<String> readFiles(String fileName){
        try {
            var reader = new BufferedReader(new FileReader(fileName));
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
