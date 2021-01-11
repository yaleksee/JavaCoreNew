package src.CHART.server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface Censored {
    String FILE_NAME = "censored.txt";
    File file = new File(FILE_NAME);

    static boolean censored(String message) {
        try {

            List<String> censored = new ArrayList<>();
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String tmp;
            while ((tmp = br.readLine()) != null) censored.add(tmp);

            for (int i = 0; i < censored.size(); i++) {
                if (censored.get(i).equalsIgnoreCase(message)) {
                    return true;
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
