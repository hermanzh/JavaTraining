package week1;

public class ArrayDemo {
    public static void main(String[] args) {
        //定义一个数组，存储整数，容器长度3个
        int[] arr = new int[3];
        System.out.println("我们认为的乱码：" + arr); //[I@4c873330 [代表数组 I代表整数 @分隔符 后边内存地址十六进制
        System.out.println("arr 的地址是：" + arr.hashCode());
    }
}
