package lt.codeacademy.andriusd;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            pirmasEtapas();   //reikalingas tik tada kai yra naujas sarasas be numeracijos
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
        var writer = new BufferedWriter(new FileWriter("./src/main/java/lt/codeacademy/andriusd/papildytivardai.txt"));
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
        System.out.println("==============Zmones kurie tekia dovanas:================");
        int varduSkaicius = lines.size() + 1;
        for (int i = 1; i < 500; i++) {
            int randomskaicius = random.nextInt(varduSkaicius);

            if (!spetiSk.contains(randomskaicius) && randomskaicius != 0) {
                String vardas = lines.get(randomskaicius - 1).split(" ")[1];
                spetiSk.add(randomskaicius);
                System.out.print(" " + vardas); // gaunu random vardus

            } else if (spetiSk.size() == 12) {
                break;
            }
        }

        System.out.println();
        System.out.println();
        for (int i = 1; i < 5000; i++) {
            int randomskaicius2 = random.nextInt(varduSkaicius);
            if (!spetiSk2.contains(randomskaicius2) && !(randomskaicius2 == 0)) {
                String vardas = lines.get(randomskaicius2 - 1).split(" ")[1];
                spetiSk2.add(randomskaicius2);
                System.out.print(" " + vardas);
            } else if (spetiSk2.size() == 12) {
                break;
            }
        }
        System.out.println();
        System.out.println("============Zmones kurie gauna dovanas================");
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
