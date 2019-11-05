import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("test.txt"));
            out = new PrintWriter(new FileWriter("output-copylines.txt"));
            String l;
            while ((l = in.readLine()) != null) {
                System.out.println(l);
                out.println(l);
            }

        } finally {
            // 进行stream的关闭操作
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}