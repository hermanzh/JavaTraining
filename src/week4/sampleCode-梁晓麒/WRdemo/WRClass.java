package com.ad.homework04.WRdemo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class WRClass implements Write,Read {

    public static Scanner sc= new Scanner(System.in);

    @Override
    public void classicWay(File sourceFile) throws IOException {
        System.out.println("---------经典的处理方式-------------");
        try (
                FileInputStream fis=new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
        )
        {
            String line=null;
            while((line= br.readLine())!=null){
                System.out.println(line.trim().toUpperCase());
            }
        }


        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void coolerWay(File sourceFile) throws IOException {
        System.out.println("---------666的处理方式-------------");

        try (
                FileInputStream fis=new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
        )
        {
            br.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void writeFile(File f) throws FileNotFoundException {

        try (
                FileOutputStream fos=new FileOutputStream(f);
                OutputStreamWriter osw=new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw);
        ){ System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while(true){
                String line =sc.nextLine().trim();
                System.out.println("输入内容为" + line);
                if(line.trim().isBlank()){
                    System.out.println("输出结束");
                    break;
                }else{
                    pw.println(line);
                    pw.flush();
                }}
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public File creatFile() throws IOException {
        System.out.println("请输入文件名：");
        String fileName = sc.nextLine().trim();
        File f = new File("."+File.separator+fileName+".txt");
        if(f.isFile())
            System.out.println("目标文件存在，删除：" + f.delete());

        System.out.println(f.createNewFile());

        return f;

    }
}
