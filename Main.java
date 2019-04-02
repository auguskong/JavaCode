import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

class ThreadA implements Callable<String> {
    private String str;

    public ThreadA(String input) {
        this.str = input;
    }

    @Override
    public String call() {
        String ans = str + "_A";
        return ans;
    }
}
class ThreadB implements Callable<String> {
    private String str;

    public ThreadB(String input) {
        this.str = input;
    }

    @Override
    public String call(String s) {
        String ans = str + "_B";
        return ans;
    }
}

class ThreadC implements Callable<String> {
    private String str;

    public ThreadC(String input) {
        this.str = input;
    }
    @Override
    public String call(String s) {
        String ans = str + "_C";
        return ans;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Executor executor=Executors.newSingleThreadExecutor();
        String s1 = executor.execute(new Thread(new ThreadA(cin)));
        String s2 = executor.execute(new Thread(new ThreadB(s1)));
        String s3 = executor.execute(new Thread(new ThreadC(s2)));
        System.out.println(s3);
    }
}