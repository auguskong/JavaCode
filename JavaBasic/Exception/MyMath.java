class MyMath {
    public static int div (int x, int y) throws ZeroException{
        int res = 0;
        if (y == 0) {
            throw new ZeroException();
        } else {
           res = x / y;
        }
        return res;
    }

    public static void main(String[] args){
        int res = 0;
        try {
            res = div(10, 0);
        } catch (ZeroException e){
            System.out.println("处理啦");
        } finally {
            System.out.println(res);
        }
    }
}

class ZeroException extends Exception {
    // 这里记得使用构造方法
    public ZeroException() {
        System.out.println("Zero Exception la la la");
    }
}