package src.less12.io.fileapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader и Writer – это аналоги InputStream и OutputStream,
 * но в отличие от них, они работают не с байтами, а с символами.
 *
 * Иногда их еще называют символьными потоками, в противовес InputStream и OutputStream – байтовым потокам.
 */

public class ReaderWriterEx {
    public static void main(String[] args) throws IOException {
        //создаем список для хранения строк
        List<String> list = new ArrayList<String>();

        // открываем файл
        File file = new File("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\document.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //пока файл не пуст – читаем из него
        while (reader.ready()) {
            list.add(reader.readLine());
        }

        //закрываем файл
        reader.close();

        List<String> list2 = Files.readAllLines(file.toPath(), Charset.defaultCharset());

        System.out.println(list2.size());
    }
}
