package lt.codeacademy.mariusp.andriusd;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            pirmasEtapas();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        antrasEtapas();
    }

    public static void pirmasEtapas() throws IOException {

        String path = "./src/resources/vardai.txt";

        List<String> lines = readLines(path);
        List<String> vardai = new ArrayList<>();

        HashMap<Integer, String> sunumeruotiVardai = new HashMap<>();
        int sk = 1;

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
        var writer = new BufferedWriter(new FileWriter("./src/main/java/lt/codeacademy/mariusp/andriusd/papildytivardai.txt"));
//
        for (var entry : sunumeruotiVardai.entrySet()) {
            writer.write(entry.getKey() + " " + entry.getValue());
            writer.newLine();
        }
        writer.flush();
        writer.close();
        System.out.println(vardai.size());

    }

    public static void antrasEtapas() throws FileNotFoundException {

        var path2 = ("./src/main/java/lt/codeacademy/mariusp/andriusd/papildytivardai.txt");
        List<String> lines = readLines(path2);
        System.out.println("Vardu skaicius=" + lines.size());

        final Random random = new Random();
        final Random random2 = new Random();

        List<Integer> spetiSk = new ArrayList<>();
        List<Integer> spetiSk2 = new ArrayList<>();
        //HashMap<Integer, String> spekSk1 = new HashMap<>();

        int varduSkaicius = lines.size() + 1;
        for (int i = 1; i < 5000; i++) {
            int randomskaicius = random.nextInt(varduSkaicius);

            if (!spetiSk.contains(randomskaicius) && !(randomskaicius == 0)) {
                spetiSk.add(randomskaicius);

            } else if (spetiSk.size() == 12) {
                break;
            }
        }
        for (int i = 1; i < 5000; i++) {
            int randomskaicius2 = random.nextInt(varduSkaicius);
            if (!spetiSk2.contains(randomskaicius2) && !(randomskaicius2 == 0) && !spetiSk.equals(randomskaicius2)) {
                spetiSk2.add(randomskaicius2);
            } else if (spetiSk2.size() == 12) {
                break;
            }
        }
        System.out.println(spetiSk);
        System.out.println(spetiSk2);

        for (int i = 0; i < spetiSk.size(); i++) {
            if (spetiSk.get(i).equals(spetiSk2.get(i))) {

                System.out.println("Vienodi elementai rasti: " + spetiSk.get(i) + " pozicijoje " + (i + 1));

            }
        }
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
