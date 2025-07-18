package GameHighScoreFinder;

import java.util.Scanner;

public class GameRankFinder {
    public static void main(String[] args) {
        Score scoreBoard = new Score();

        scoreBoard.generateSortedScoreList(100);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you game Score : ");
        int myScore = sc.nextInt();
        sc.nextLine();

        int myRank = scoreBoard.findRank(myScore);

        System.out.println(myRank);

        System.out.println("Top Scores:");
        System.out.println(scoreBoard.topScores);

    }
}
