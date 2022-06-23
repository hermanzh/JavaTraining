package week3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //（1）获取当前时间
        LocalDateTime date = LocalDateTime.now();
        String nowtime = dateTimeFormatter.format(date);
        System.out.println("系统当前时间      ：" + nowtime);

        //（2）获取当前时间的前12小时时间
//        LocalDateTime localDateTime = date.minusHours(12);
//        String nowtime12=dateTimeFormatter.format(localDateTime);
//        System.out.println("获取当前时间的前12小时时间      ："+nowtime12);

        LocalDateTime localDateTime = date.minusMonths(1);
        String nowtime1Month = dateTimeFormatter.format(localDateTime);
        System.out.println("获取当前时间的前1个月时间      ：" + nowtime1Month);
    }
}

