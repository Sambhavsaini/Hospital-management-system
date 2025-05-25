package util;
import java.io.*;
public class FileUtil {
    public static BufferedReader getReader(String filePath) throws IOException {
        return new BufferedReader(new FileReader(filePath));
    }

    public static BufferedWriter getWriter(String filePath, boolean append) throws IOException {
        return new BufferedWriter(new FileWriter(filePath, append));
    }

}
