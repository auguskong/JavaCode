/**
* Date: 11/15/2018
* Type: basic reference
* 最后的返回结果是AB, B
* 分析: 在main方法之中，首先声明了两个引用a 和 b, a指向了栈内存中的StringBuffer A，
        b指向了栈内存之中的StringBuffer B, 在operator方法之中, x 和 y分别拷贝了引用a 和 b
        所以当调用append命令时,在栈内存中会进行"A".append("B")的操作，此时a和x两个引用指向的
        "A"会变为一个"AB",同时y也会指向x所指向的栈内存空间"AB", 但是当operator方法调用结束时,
        x和y两个引用也会同时消失,也就是说x 和 y是a 和 b的引用的拷贝, 会影响栈内存空间, 但不会影响a和b
        的引用, 所以最后的结果会是a 指向了被修改后的"AB",而b仍然会指向原来所指向的"B"

在operator方法中x 和 y,首先分别复制了 a 和 b的引用
*/


class TestReferenceString {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
        System.out.println("y: " + y); // pring "AB"
    }
}