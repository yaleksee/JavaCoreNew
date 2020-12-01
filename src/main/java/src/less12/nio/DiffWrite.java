package src.less12.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiffWrite {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static void main(String[] args) throws Exception {

        File in = new File("C:\\myrepo\\less\\JavaCoreNew\\src\\main\\java\\src\\less12\\in.txt");
        File out = new File("out.txt");
        copyFile(in, out);
        copyFileNio(in, out);
    }

    public static void copyFile(File in, File out) throws Exception {

        System.out.println("Before Read :" + sdf.format(new Date()));

        try (FileInputStream fis = new FileInputStream(in);
             FileOutputStream fos = new FileOutputStream(out);) {
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (Exception e) {
            throw e;
        }

        System.out.println("After Read :" + sdf.format(new Date()));

    }

    public static void copyFileNio(File in, File out) throws IOException {

        System.out.println("Before Read :" + sdf.format(new Date()));

        try (FileChannel inChannel = new FileInputStream(in).getChannel();
             FileChannel outChannel = new FileOutputStream(out).getChannel();) {

            inChannel.transferTo(0, inChannel.size(), outChannel);

        } catch (IOException e) {
            throw e;
        }

        System.out.println("After Read :" + sdf.format(new Date()));
    }
}
