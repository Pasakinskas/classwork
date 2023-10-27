package lt.codeacademy.ernestask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        List<String> vardai;
        List<String> gavoDovana = new ArrayList<>();

        vardai = SecretSanta.readLines("./src/resources/vardai.txt");
        System.out.println(vardai);

        for (int i = 0; i < vardai.size(); i++) {

            String vardas = vardai.get(i);
            boolean baigta = false;
            while (!baigta) {
                int randomVardoNumeris = random.nextInt(vardai.size());
                String randomVardas = vardai.get(randomVardoNumeris);

                if (randomVardas.equals(vardas)) {
                } else if (gavoDovana.contains(randomVardas)) {
                } else {
                    System.out.println(randomVardas + " gavo dovana nuo " + vardas);
                    gavoDovana.add(randomVardas);

                    baigta = true;
                }
            }
        }
    }
}
