public class Demo {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c = 9;
        if (a == 3) {
            a++;
            System.out.println("inside if (a == 3)");
        }
        else if (b == 5) {
            b++;
            System.out.println("inside if (b == 5)");
        }
        if (c == 10) {
            c--;
            System.out.println("inside else if(c == 10)");
        } else {
            System.out.println("inside else");
            c--;
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

    }
}