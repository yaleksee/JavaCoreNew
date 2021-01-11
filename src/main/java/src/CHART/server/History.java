package src.CHART.server;

import java.io.*;
import java.util.ArrayList;

public class History {
    private final static String FILE_NAME = "history.txt";
    private final static int MAX_MESSAGES = 100;
    private final static File file = new File(FILE_NAME);

    public static void addHistory(String message) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(file, true);
        byte[] buffer = message.getBytes();

        try {
            if (file.exists()) fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadHistory() throws IOException {
        ArrayList<String> bandWidth = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String tmp;
        while ((tmp = br.readLine()) != null) {
            bandWidth.add(tmp);
            if (bandWidth.size() > MAX_MESSAGES)
                bandWidth.remove(0);
        }
        String res = "";
        fis.close();
        for (String line : bandWidth) {
            res += line + "\n";
        }
        return res;
    }
}
