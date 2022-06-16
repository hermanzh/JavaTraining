package week2;

import java.util.Scanner;

/*
阿里巴巴 Java 开发手册
https://github.com/alibaba/p3c/blob/master/Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C(%E9%BB%84%E5%B1%B1%E7%89%88).pdf
 */

public class Test {
    public static String getInput() {
        System.out.println("请输入：");
        // nextInt() 接收int型，nextLine接收String. 如果需要允许接受用户任意输入，这里可以使用nextLine然后通过对String的内容判断进行分类
        return new Scanner(System.in).nextLine();
    }

    static public void main(String[] args){
        String input = getInput();
        System.out.println(input);

        Test test = new Test();
        String testClassCallStaticFunction = test.getInput(); // 类对象可以直接访问类静态变量和方法，但是不推荐。这里IDEA会报问题
        System.out.println(testClassCallStaticFunction);
    }
}
