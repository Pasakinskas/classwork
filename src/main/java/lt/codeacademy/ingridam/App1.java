package lt.codeacademy.ingridam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App1 {

    public static void main(String[] args) {

        Random random = new Random();
        List<String> vardai = SecretSanta.readFiles("./src/resources/vardai.txt");
        List<String> kopijaVardu = new ArrayList<>(vardai);
    }
}
