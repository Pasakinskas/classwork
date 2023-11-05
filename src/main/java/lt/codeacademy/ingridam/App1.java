package lt.codeacademy.ingridam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App1 {

    public static void main(String[] args) {

        Random random = new Random();

        List<String> vardai = gautiDuomenisIsFailo();

        List<Pora> poros = new ArrayList<>();

        for (int i = 0; i < vardai.size(); i++) {
            Pora pora = new Pora();
            pora.dovanoja = vardai.get(i);
            pora.gaunaDovana = generuotiDovanosGaveja(pora.dovanoja, poros, random, vardai);
            poros.add(pora);
            System.out.println(pora.dovanoja + " -> " + pora.gaunaDovana);
        }
    }

    private static List<String> gautiDuomenisIsFailo() {
        List<String> vardai = new ArrayList<>();
        var vardaiList = SecretSanta.readFiles("./src/resources/vardai.txt");
        String[] atskirosEiluteDalys = vardaiList.split(",");
        for (int i = 0; i < atskirosEiluteDalys.length; i++) {
            vardai.add(atskirosEiluteDalys[i]);
        }
        return vardai;
    }

    private static String generuotiDovanosGaveja(String dovanoja, List<Pora> poros, Random random, List<String> vardai) {
        int index = random.nextInt(0, vardai.size()); //gauname random dovanos gaveja pagal random Index
        String galbutGaunaDovana = vardai.get(index);
        Boolean tikraiGaunaDovana = false;
        while (!tikraiGaunaDovana) { //generuojame random zmogu kol surandame tinkama
            if (arGaliButiPora(dovanoja, galbutGaunaDovana, poros)) { // Jeigu nedovanoja sau ir nedovanoja tam kas jau gavo dovana
                tikraiGaunaDovana = true;
            } else {
                index = random.nextInt(0, vardai.size());
                galbutGaunaDovana = vardai.get(index);
            }
        }
        return galbutGaunaDovana;
    }

    private static boolean arJauGavoDovana(List<Pora> poros, String galbutGaunaDovana) {
        for (int i = 0; i < poros.size(); i++) {
            if (galbutGaunaDovana.equals(poros.get(i).gaunaDovana)) {
                return true;
            }
        }
        return false;
    }

    private static boolean arGaliButiPora(String dovanoja, String gaunaDovana, List<Pora> poros) {
        return !dovanoja.equals(gaunaDovana) && !arJauGavoDovana(poros, gaunaDovana);
    }
}
