/**
* 03/21/2019
* 简单的枚举类使用demo
**/

// 定义枚举类
enum Color {

    RED("红色"), GREEN("绿色"), BLUE("蓝色"); //实例化对象
    private String title;

    // 构造方法必须非私有化定义
    private Color(String title) {
        this.title = title;
    }

    public String toString() {
        return this.title;
    }
}

public class ColorEnum {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c.ordinal() + " " + c.name());
        }
    }
}