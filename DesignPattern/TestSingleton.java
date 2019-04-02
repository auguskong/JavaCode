
// 饿汉式单例模式: 在类加载时就创建好实例,后面不一定会用上
class EagerSingleton {
    private EagerSingleton() {}; // 构造方法私有化
    private static EagerSingleton instance = new EagerSingleton(); //内部产生实例化对象
    public static EagerSingleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("Create Eager Singleton Instance");
    }

}

// 懒汉式单例模式: 在第一次调用getInstance()方法的时候创建实例
class LazySingleton {
    private static LazySingleton instance;  //内部产生实例化对象

    private LazySingleton() {}; // 构造方法私有化

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void print() {
        System.out.println("Create Lazy Singleton Instance");
    }

}

class SyncSingleton {
    private static SyncSingleton instance;

    private SyncSingleton() {};

    public static synchronized SyncSingleton getInstance() {
        if (instance == null) {
            instance = new SyncSingleton();
        }
        return instance;
    }

    public void print() {
        System.out.println("Create Sync Singleton Instance");
    }
}

class DoubleCheckSingleton {
    //用volatile修饰instance变量保证初始化实例时对多线程课件
    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {};

    public static DoubleCheckSingleton getInstance() {
        // if中的代码只有在第一次实例化的时候才会执行
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public void print() {
        System.out.println("Create Double Check Singleton Instance");
    }
}


public class TestSingleton {
    public static void main(String[] args) {
        LazySingleton s = null;
        s = LazySingleton.getInstance();
        s.print();
    }
}