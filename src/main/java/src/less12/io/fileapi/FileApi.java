package src.less12.io.fileapi;

import java.io.File;
import java.io.IOException;

/**
 * Класс File, определенный в пакете java.io, не работает напрямую с потоками.
 * Его задачей является управление информацией о файлах и каталогах.
 * Хотя на уровне операционной системы файлы и каталоги отличаются,
 * но в Java они описываются одним классом File.
 *
 * В зависимости от того, что должен представлять объект File - файл или каталог,
 * мы можем использовать один из конструкторов для создания объекта:
 *
 * File(String путь_к_каталогу)
 * File(String путь_к_каталогу, String имя_файла)
 * File(File каталог, String имя_файла)
 */

public class FileApi {
    // Работа с каталогами
    public static void main(String[] args) {

        // определяем объект для каталога
        File dir = new File("C:\\Program Files");
        // если объект представляет каталог
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {

                if (item.isDirectory()) {

                    System.out.println(item.getName() + "  \t folder");
                } else {

                    System.out.println(item.getName() + "\t file");
                }
            }
        }
    }
}

class FileApi2 {

    public static void main(String[] args) {

        // определяем объект для каталога
        File myFile = new File("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\document.txt");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent folder: " + myFile.getParent());
        if (myFile.exists())
            System.out.println("File exists");
        else
            System.out.println("File not found");

        System.out.println("File size: " + myFile.length());
        if (myFile.canRead())
            System.out.println("File can be read");
        else
            System.out.println("File can not be read");

        if (myFile.canWrite())
            System.out.println("File can be written");
        else
            System.out.println("File can not be written");

        // создадим новый файл
        File newFile = new File("C:\\myrepo\\less\\JavaCoreNew\\NewFile.txt");
        try {
            boolean created = newFile.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        System.out.println(newFile.getAbsolutePath());
        System.out.println(newFile.canRead());
        System.out.println(newFile.canWrite());
        System.out.println(newFile.exists());
        System.out.println(newFile.getName());
        System.out.println(newFile.getParent());
        System.out.println(newFile.getPath());
        System.out.println(newFile.lastModified());
        System.out.println(newFile.isFile());
        System.out.println(newFile.isDirectory());
        System.out.println(newFile.isAbsolute());
    }
}
