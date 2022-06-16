package week2.AIGuessNumber;

/**
 * @author Sijie Chen
 * 玩家功能尚未开发完全，后续想实现玩家PK功能
 */

public class Player {
    public int GuessCount;
    public String name;
    public boolean quitORnot;

    public Player() {
        this("nobody", true);
    }

    /**
     * 初始化玩家
     *
     * @param name
     * @param quitORnot
     */
    public Player(String name, boolean quitORnot) {
        this.GuessCount = 0;
        this.name = name;
        this.quitORnot = quitORnot;
    }

    /**
     * 玩家玩游戏
     */
    public void playGame() {
        while (!quitORnot) {
            AIGuessNumber AI = new AIGuessNumber(this.GuessCount);
            this.GuessCount = AI.guess();
            if (this.GuessCount == -1) {
                this.quitORnot = true;
            }
        }
    }
}


