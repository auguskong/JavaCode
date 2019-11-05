public class ThreadTest {
    private static void attack() {
        System.out.println("Fight");
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                attack();
            }
        };
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        t.start();

        t.run();
    }
}
