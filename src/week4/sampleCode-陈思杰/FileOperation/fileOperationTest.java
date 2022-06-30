package Week4.FileOperation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
  @Author: 陈思杰
 */

public class fileOperationTest {
    public static void main(String[] args) {
        boolean stop = false;
        Scanner in = new Scanner(System.in);
        FileOperation file = new FileOperation();
        while (!stop) {
            System.out.println(
                    "1.设置根文件夹。\n" +
                            "2.创建文件夹。\n" +
                            "3.创建文本文件。\n" +
                            "4.写入文本文件。\n" +
                            "5.读取文本文件。\n");
            System.out.println("请输入想要进行的操作：");
            int choose = in.nextInt();
            switch (choose) {
                case 1:
                    String root = in.nextLine().trim();
                    file.fileJump();
                    break;
                case 2:
                    file.createDirs();
                    break;
                case 3:
                    try {
                        file.createFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 4:
                    file.write2File(file.target);
                    break;
                case 5:
                    File sourceFile = new File(String.valueOf(file.target));
                    file.readFile(sourceFile);
                    break;

            }
        }
    }
}
