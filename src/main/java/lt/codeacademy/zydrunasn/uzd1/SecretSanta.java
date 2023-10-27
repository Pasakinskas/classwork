package lt.codeacademy.zydrunasn.uzd1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public final class SecretSanta {
    public void peopleToExchangeGifts() throws IOException {
        List<String> people = fileReader();
        System.out.printf("%s -> %s",
                randomPersonName(people),
                randomPersonName(people));
    }

    private List<String>  fileReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/vardai.txt"));
        List<String> list = List.of(reader.readLine().split(","));
        return list;
    }

    private String randomPersonName(List<String> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}
