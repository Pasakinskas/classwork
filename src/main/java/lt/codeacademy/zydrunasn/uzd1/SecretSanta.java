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
        final String person1, person2;
        List <String> people = fileReader();

        person1 = randomPersonName(people);
        people.remove(person1);
        person2 = randomPersonName(people);

        System.out.printf("%s -> %s",person1, person2);
    }

    private ArrayList<String>  fileReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/vardai.txt"));
        ArrayList<String> list = new ArrayList<>(List.of(reader.readLine().split(",")));
        return list;
    }

    private String randomPersonName(List<String> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}
