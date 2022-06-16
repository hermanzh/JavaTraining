package week2.AIGuessNumber;

import java.util.Scanner;

/**
 * @author Sijie Chen
 */

public class AIGuessNumber {
    int startnum;
    int endnum;
    int guessChance;
    int mod;
    int currectcount;

    int num;
    Scanner in = new Scanner(System.in);

    public AIGuessNumber(int currectcount) {
        System.out.println("请输入开始数字（大于0的整数）：");
        this.startnum = startnumJudge(in.nextInt());
        System.out.println("请输入大于0且大于开始数字的整数作为结束数字：");
        this.endnum = endnumJudge(in.nextInt());
        System.out.println("请设置猜测次数：");
        this.guessChance = in.nextInt();
        this.mod = endnum - startnum;
        this.currectcount = currectcount;
        describe();
        this.num = (int) (((Math.random() * this.endnum * 100) % this.mod) + this.startnum);
        if (this.num <= this.startnum) {
            this.num += 1;
        }
        if (this.num >= this.endnum) {
            this.num -= 1;
        }
        System.out.println("答案是：" + this.num);
    }

    /**
     * 判断开始数字是否符合标准
     *
     * @param startnum
     * @return
     */
    public int startnumJudge(int startnum) {
        while (startnum <= 0) {
            System.out.println("请输入开始数字（大于0的整数）：");
            startnum = in.nextInt();
        }
        return startnum;
    }

    /**
     * 判断结束数字是否符合标准
     *
     * @param endnum
     * @return
     */
    public int endnumJudge(int endnum) {
        while (endnum <= 0 || endnum <= this.startnum) {
            System.out.println("请输入大于0且大于开始数字的整数作为结束数字：");
            endnum = in.nextInt();
        }
        return endnum;
    }

    public void describe() {
        System.out.println("----------------游戏正式开始----------------");
        System.out.println("目标整数在" + this.startnum + "到" + this.endnum + "之间，你共有" + this.guessChance + "次机会。");
    }

    /**
     * 输入数字与目标数字的判断逻辑
     *
     * @return
     */
    public int guess() {
        boolean stopgame = false;
        while (!stopgame) {
            System.out.println("请输入猜测的数字，输入-1退出游戏。");
            int guessnum = in.nextInt();
            if (guessnum == this.num) {
                System.out.println("你猜对了！");
                return this.currectcount += 1;
            }
            this.guessChance -= 1;
            if (this.guessChance == 0) {
                System.out.println("你太菜了，自动退出游戏。\n" + "共猜对了：" + this.currectcount + "次数字。");
                return -1;
            }
            //退出游戏
            if (guessnum < 0) {
                System.out.println("退出游戏。\n" + "共猜对了：" + this.currectcount + "次数字。");
                return -1;
            }
            //比大小
            if (guessnum < this.num) {
                System.out.println("你猜得小了，还剩余" + this.guessChance + "次机会。");
            } else if (guessnum > num) {
                System.out.println("你猜得大了，还剩余" + this.guessChance + "次机会。");
            }
        }
        return currectcount;
    }
}
