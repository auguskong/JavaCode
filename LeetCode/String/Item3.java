
// 方法1: 使用private 构造器
public class Elvis {

    // ELvis类的构造器只在内部调用一次
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {...}

    public void leaveTheBuilding() { ... }
}

// invoke the private constructor reflectively
// AccessibleObject.setAccessible()


// 方法2: Singleton with static factory
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {...}
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() { ... }
}

// 方法3: 使用enum 局限: 不能对必须将Enum类作为父类的类使用
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() { ... }
}