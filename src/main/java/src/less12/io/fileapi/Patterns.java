package src.less12.io.fileapi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Patterns {
    public static void main(String[] args) throws IOException {

        //   передаем объект InputStream в конструктор InputStreamReader!
        //   В качестве InputStream мы используем уже ставшую привычной переменную System.in:
        //   мы передаем объект «адаптируемого» класса «внутрь», то есть в конструктор класса-адаптера.
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        /*
         * Есть класс OutputStream, который умеет записывать только байты; есть абстрактный класс Writer,
         * который умеет работать с символами, и есть два несовместимых интерфейса.
         *
         * Эту проблему вновь успешно решает паттерн Адаптер.
         * При помощи класса OutputStreamWriter мы легко «адаптируем» два интерфейса классов
         * Writer и OutputStream друг другу. И, получив байтовый поток OutputStream в конструктор,
         * с помощью OutputStreamWriter мы, тем не менее, можем записывать символы, а не байты!
         */

        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\NewFile.txt"));
        streamWriter.write(32144);
        streamWriter.close();

        /*
         * На схеме в презентации InputStream – абстрактный компонент.
         * Конкретные компоненты: FileInputStream, StringBufferInputSteam, ByteArrayInputStream,
         * ObjectInputStream и др.
         *
         * Абстрактный декоратор – FilterInputStream, его потомки – конкретные декораторы:
         *
         * BufferedInputStream - буферизует ввод для повышения производительности
         * и дополняет интерфейс новым методом readLine() для построчного чтения символьных данных.
         *
         * LineNumberInputStream - добавляет возможность подсчета строк в процессе чтения данных.
         */
    }
}
