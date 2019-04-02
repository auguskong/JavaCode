/* 参考博客: https://blog.csdn.net/ns_code/article/details/17485221
https://blog.csdn.net/qq_30816657/article/details/80297646
*/
public class ExceptionSample {
    public static int sampleOne() {
        try {
            int i = 1 / 0;
        return 0;
        } catch (Exception e) { //为什么这里不返回 1 ？

            return 1;
        } finally {
            /* finally块中的内容会先于try中的return语句执行，
            如果finall语句块中也有return语句的话，那么直接从finally中返回了，
            这也是不建议在finally中return的原因。
            */
            return 2;
        }
    }

    /*
    print1 num: 10
    print2 num: 10
    print3 num: 30
    print4 num: 30
    50
    */
    private static int sampleTwo(){
        int num = 10;
        try {
            System.out.println("print1" + " num: " + num);
            int err = 10 / 0;
            return num += 80;
        } catch(Exception e){
            System.out.println("print2" + " num: " + num);
            //System.exit(0);
            return num += 20;
        } finally{
            if (num > 20){
                System.out.println("print3" + " num: " + num);
            }
            System.out.println("print4" + " num: " + num);
            num = 50;
            return num;
        }
    }
    /*
    print1 num: 10
    print3 num: 90
    print4 num: 90
    90
    */
    private static int sampleThree(){
        int num = 10;
        try {
            System.out.println("print1" + " num: " + num);
            return num += 80;
        } catch(Exception e){
            System.out.println("print2" + " num: " + num);
            return num += 20;
        } finally{
            if (num > 20){
                System.out.println("print3" + " num: " + num);
            }
            System.out.println("print4" + " num: " + num);
            return num;
        }
    }

    // 返回值是 1
    public static int beforeFinally(){
        int a = 0;
        try{
            a = 1;
            return a;
        }finally{
            a = 2;
        }
    }
    // 返回值是2
    /* 在这里，finally{}里也有一个return，那么在执行这个return时，就会更新临时栈中的值。
    同样，在执行完finally之后，就会通知主程序请求返回了，即将临时栈中的值取出来返回。故返回值是2.
    */
    public static int beforeFinallyTwo(){
        int a = 0;
        try{
            a = 1;
            return a;
        }finally{
            a = 2;
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(sampleOne());
        System.out.println(sampleTwo());
        System.out.println(sampleThree());
        System.out.println(beforeFinally());
    }
}
