package kyh.textadventure;

import java.util.Arrays;

public class HighScores {

    public int score = 5;
    String bestPlayerName;
    int position = 0;

    int ranking [3][5]={
        {position, bestPlayerName, score},
        {position, bestPlayerName, score},
        {position, bestPlayerName, score},
        {position, bestPlayerName, score},
        {position, bestPlayerName, score}
    };

    String HighScores(int inPosition, int inScore, String inName){
        position = inPosition;
        score = inScore;
        bestPlayerName = inName;
    }

    public static void printRanking(){
        System.out.println();
    }

}
