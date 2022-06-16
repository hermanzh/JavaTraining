package week2.AIGuessNumber;

import java.util.Scanner;

/**
 * @author Sijie Chen
 */

public class AIGuessNumberApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player player = new Player("CSJ", false);
        player.playGame();
    }
}
