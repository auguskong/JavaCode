import java.util.HashSet;

class ExtractSummary {
    public static void main(String[] args) {
        String input = "love I love you baby love my heart baby love baby";
        String[] keys = {"love", "baby"};
        String res = extractSummary(input, keys);
        System.out.println(res);
    }

    private static String extractSummary(String description,String[] keys) {
        String[] words = description.split(" ");
        int pStart = 0;
        int pEnd = 0;
        int start = 0;
        int end = 0;
        int len = words.length;
        int dis = Integer.MAX_VALUE;
        boolean flag = true;

        while (flag) {
            while (pEnd < len &&
                !isAllExisted(words, pStart, pEnd, keys)) {
                pEnd++;
            }

            while (isAllExisted(words, pStart, pEnd, keys)) {
                if (pEnd - pStart < dis) {
                    dis = pEnd - pStart;
                    end = pEnd;
                    start = pStart;
                }
                pStart++;
            }

            if (pEnd >= len) {
                flag = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static boolean isAllExisted(String[] input,
                                        int start, int end,
                                        String[] keys) {

        HashSet<String> words = new HashSet<>();
        //System.out.println("*****");
        for (int i = start; i < end; i++) {
            //System.out.print(input[i] + " ");
            if (!words.contains(input[i])) {
                words.add(input[i]);
            }
        }

        for (int i = 0; i < keys.length; i++) {
            if (!words.contains(keys[i])) {
                return false;
            }
        }

        return true;
    }
}
