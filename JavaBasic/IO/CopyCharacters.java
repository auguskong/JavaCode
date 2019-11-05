/* FileReader 继承自 Reader
   FileWriter 继承自 Writer
   IOException
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("test.txt");
            out = new FileWriter("output-c.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
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