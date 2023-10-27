package lt.codeacademy.zydrunasn;

import lt.codeacademy.zydrunasn.uzd1.SecretSanta;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        SecretSanta secretSanta = new SecretSanta();
        secretSanta.peopleToExchangeGifts();
    }
}
