import java.util.Iterator;
import java.util.Set;

public class IteratorOutput {
    public static void main(String[] args) throws Exception {
        Set<String> allStrings = Set.of("Hello", "World", "Kong");
        Iterator<String> iter = allStrings.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }
    }
}