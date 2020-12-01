package src.less12.io.fileapi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputEx {
    public static void main(String[] args) throws Exception
    {
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\result.txt");

        byte[] buffer = new byte[10];
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
