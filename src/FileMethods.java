/**
 * Created by Dariya on 29.11.2015.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.nio.file.Files.exists;

public class FileMethods {
    //запись в файл
    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter print = new PrintWriter(file.getAbsoluteFile());

            try {
                print.print(text);
            } finally {
                print.flush();
                print.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //чтение файла
    public static List<String> read(String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<String>();
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    list.add(s);
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<String> sortByLength(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1;
                }
                if(o1.length() < o2.length()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        return list;
    }
}
