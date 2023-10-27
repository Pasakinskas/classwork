package lt.codeacademy.vaidasv;
import lt.codeacademy.vaidasv.uzd1.SecretSanta;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        SecretSanta secretSanta = new SecretSanta();
        secretSanta.nameReader();
        System.out.println(secretSanta.getNameList());

    }
}
