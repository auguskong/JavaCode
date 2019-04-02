/* 一个枚举类的简单使用实例
* 2019/03/21
*
*/

//使用了枚举类避免Sex一栏的信息被错填
enum Sex {
    MALE("男"), FEMALE("女");
    private String title;
    private Sex(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
}

class Person {
    private String name;
    private int age;
    private Sex sex;
    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String toString() {
        return "姓名: " + this.name + ", 年龄: " + this.age + ", 性别: " + this.sex;
    }
}

public class EnumDemo {
    public static void main(String args[]) {
        System.out.println(new Person("张三",24,Sex.MALE));
    }
}