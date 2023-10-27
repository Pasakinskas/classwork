package lt.codeacademy.zydrunasn.uzd1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class SecretSanta {
    public void peopleToExchangeGifts() throws IOException {
        String person1, person2;
        List <String> people = fileReader();

        while (!people.isEmpty()) {
            person1 = randomPersonName(people);
            people.remove(person1);
            person2 = randomPersonName(people);
            people.remove(person2);
            System.out.printf("%s -> %s\n",person1, person2);
        }
    }

    private ArrayList<String>  fileReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/vardai.txt"));
        return new ArrayList<>(List.of(reader.readLine().split(",")));
    }

    private String randomPersonName(List<String> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}
