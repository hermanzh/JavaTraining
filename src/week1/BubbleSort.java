package week1;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    /*
           获取用户输入
     */
    public static String getInput() {
        System.out.println("请输入：");
        return new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        String input = getInput();
        int length = input.length();

        char[] inputCharArr;
        int[] inputAsciiArr = new int[length];

/*
        for(int i = 0; i < length; i++){
            inputCharArr[i] = input.charAt(i);
        }
*/
        inputCharArr = input.toCharArray(); // 功能同上注释,将字符串转换成字符数组

        int j;
        boolean isSortNotNeeded; // 判断是否已经不需要再进行排序，如一次完整遍历后没有发生位置交换表示序列已经有序，无需继续

        for (int i = 0; i < length - 1; i++) {
            isSortNotNeeded = true; // 每次遍历置为true，继续遍历
            for (j = 0; j < length - 1 - i; j++) {
                if (inputCharArr[j] < inputCharArr[j + 1]) { // 如果两个相邻的元素前小后大，则进行交换
                    char tmp = inputCharArr[j + 1];
                    inputCharArr[j + 1] = inputCharArr[j];
                    inputCharArr[j] = tmp;
                    isSortNotNeeded = false; // 如果发生交换就置为false, 说明排序还未完成
                }
            }
            if (isSortNotNeeded) {
                break; // 排序提前结束，跳出循环
            }
        }

        for (int k = 0; k < length; k++) {
            inputAsciiArr[k] = (int) inputCharArr[k]; // 强制类型转换
        }

        System.out.println("有序字符串：" + String.valueOf(inputCharArr));
        System.out.println("ASCII码：" + Arrays.toString(inputAsciiArr));
    }
}
