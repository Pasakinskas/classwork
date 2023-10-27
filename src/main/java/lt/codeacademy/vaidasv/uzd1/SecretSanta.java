package lt.codeacademy.vaidasv.uzd1;

import java.io.*;
import java.util.List;

public class SecretSanta {
    private List<String> nameList;

    public void nameReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/vardai.txt"));
        setNameList(List.of(reader.readLine().split(",")));
        }

        public void drawGiftPairs(){


        }
    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    }

