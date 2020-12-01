package src.less12.io.game;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String[] territoriesInfo = {"Россия 10", "China 3", "Atlandida 100"};
        String[] resourcesInfo = {"Россия 1000", "China -300", "Atlandida 1"};
        String[] diplomaticInfo = {"Россия war with Atlantida", "China netral", "Atlandida death"};

        SaveGame saveGameSAVES = new SaveGame(territoriesInfo, resourcesInfo, diplomaticInfo);

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\yalekseenko\\Desktop\\save.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(saveGameSAVES);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\yalekseenko\\Desktop\\save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SaveGame saveGameLoad = (SaveGame) objectInputStream.readObject();
        System.out.println(saveGameLoad);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(saveGameSAVES);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(saveGameLoad.equals(saveGameSAVES));
        System.out.println(saveGameLoad == saveGameSAVES);
    }
}
