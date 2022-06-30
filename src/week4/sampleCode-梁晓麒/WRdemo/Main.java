package com.ad.homework04.WRdemo;

import java.io.File;
import java.io.IOException;

/*
  @Author: 梁晓麒
 */
public class Main {
    public static void main(String[] args) throws IOException {
        WRClass wr = new WRClass();

        //todo 写入
        File f = wr.creatFile();
        wr.writeFile(f);
        System.out.println("写入结束");

        //todo 读取
        wr.classicWay(f);

        //wr.coolerWay(f);

    }
}
