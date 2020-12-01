package src.less12.nio;

import java.io.IOException;
import java.nio.file.*;

/**
 * Примеры классов Files и Path
 */

public class FilesAndPath {
    public static void main(String[] args) throws IOException {
        ex1();
        ex2();
        ex3();
    }



    public static void ex1() {

        // Cоздание объекта Path через вызов статического метода get() класса Paths
        Path testFilePath = Paths.get("C:\\Users\\yalekseenko\\Desktop\\save.txt");

        //Пример строки создания объекта Path пути для запуска в Windows
        //Path testFilePath = Paths.get("...\\testfile.txt");

        //Вывод инормации о файле
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: "
                + testFilePath.getParent());
        //Вывод элементов пути
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }

    public static void ex2() throws IOException {
        Path testFilePath = Paths.get("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\123.txt");

        //Пример строки пути для запуска в Windows
        //Path testFilePath = Paths.get(".\\Test");

        System.out.println("The file name is: " + testFilePath.getFileName());
        System.out.println("It's URI is: " + testFilePath.toUri());
        System.out.println("It's absolute path is: "
                + testFilePath.toAbsolutePath());
        System.out.println("It's normalized path is: "
                + testFilePath.normalize());

        //Получение другого объекта строки по нормализованному относительному пути
        Path testPathNormalized = Paths
                .get(testFilePath.normalize().toString());
        System.out.println("It's normalized absolute path is: "
                + testPathNormalized.toAbsolutePath());
        System.out.println("It's normalized real path is: "
                + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
    }

    public static void ex3() {
        Path path = Paths.get("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\123.txt");
        try {
            Object object = Files.getAttribute(path, "creationTime");
            System.out.println("Creation time: " + object);

            //Здесь указан третий параметр
            object = Files.getAttribute(path, "lastModifiedTime",
                    LinkOption.NOFOLLOW_LINKS);
            System.out.println("Last modified time: " + object);

            object = Files.getAttribute(path, "size");
            System.out.println("Size: " + object);

            object = Files.getAttribute(path, "isDirectory");
            System.out.println("isDirectory: " + object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
