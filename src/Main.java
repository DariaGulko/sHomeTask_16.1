import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Dariya on 29.11.2015.
 */
public class Main {
    private static String text = "4144423\r\n31534\r\n1345";
    private static String fileName = "C://Users//Dariya//Documents/sHomeTask_16.1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        FileMethods.write(fileName, text);
        List<String> list = FileMethods.read(fileName);
        System.out.println(list);
        FileMethods.sortByLength(list);
        System.out.println(list);
    }
}
