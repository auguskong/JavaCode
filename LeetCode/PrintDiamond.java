public class PrintDiamond {
    public static void main(String[] args) {
        printDiamond(5);
    }

    public static void printDiamond(int height) {
        int width = height * 2 - 1;
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= width + 1; j++) {
                if (j > height - i && j < height + i) {
                    System.out.print(" " + j - i);
                } else {
                   System.out.print(" ");
                }
            }
            System.out.println("");
        }
        for (int i = height; i > 0; i--) {
            for (int j = 0; j <= width + 1; j++) {
                if (j > height - i && j < height + i) {
                    System.out.print(" " + i);
                } else {
                   System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}