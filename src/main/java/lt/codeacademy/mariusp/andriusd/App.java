package lt.codeacademy.mariusp.andriusd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        antrasEtapas();
    }

    public static void pirmasEtapas() {

        String path = "./src/resources/vardai.txt";

        List<String> lines = readLines(path);
        List<String> vardai = new ArrayList<>();
        HashMap<Integer, String> sunumeruotiVardai = new HashMap<>();
        int sk = 0;

        for (String line : lines) {
            String[] splitVardai = line.split(", ");
            for (String vardas : splitVardai) {
                vardai.add(vardas);
                sunumeruotiVardai.put(sk++, vardas);
            }
        }
        sunumeruotiVardai.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }

    public static void antrasEtapas() {
        final Random random = new Random();
        final Random random2 = new Random();

        List<Integer> spetiSk = new ArrayList<>();
        List<Integer> spetiSk2 = new ArrayList<>();

        int varduSkaicius = 15;
        for (int i = 0; i < varduSkaicius; i++) {
            int randomskaicius = random.nextInt(varduSkaicius);
            int randomskaicius2 = random.nextInt(varduSkaicius);

            if (!spetiSk.contains(randomskaicius)) {
                spetiSk.add(randomskaicius);
            }
            if (!spetiSk2.contains(randomskaicius2)) {
                spetiSk2.add(randomskaicius2);
            }
        }
        System.out.println(spetiSk);
        System.out.println(spetiSk2);


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
