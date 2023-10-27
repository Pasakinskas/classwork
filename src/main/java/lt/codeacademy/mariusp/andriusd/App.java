package lt.codeacademy.mariusp.andriusd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        String path = "./src/resources/vardai.txt";

        List<String> lines = readLines("./src/resources/vardai.txt");
        for (String line : lines) {
            System.out.println((line));
        }

        Random random=new Random();

    }

    public static List<String> readLines(String path) {

        try {
            var reader = new BufferedReader(new FileReader(path));
            return reader.lines().collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
