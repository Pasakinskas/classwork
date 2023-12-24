package lt.codeacademy.ernestask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecretSanta {

    public static List<String> readLines(String filePath) throws IOException{
        try {
            var bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();
                return Arrays.asList(line.split(" "));
        } catch (IOException ioException){
            throw new RuntimeException(ioException);
        }
    }
}
