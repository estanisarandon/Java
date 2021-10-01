package kyh.textadventure;

import java.util.Scanner;

public class AdventureGame {

    public void initialisering () {
        //Initialisering
        Rooms pinkRoom = new Rooms("Pink room", "This is a room with pink walls filled with pink furniture");
        Rooms entrance = new Rooms("The entrance", "This is the entrance hall");
        Rooms livingroom = new Rooms("Living room", "This is a room with a TV");
        Rooms studio = new Rooms("Studio", "This is a room full with books and a desk in the middle");
        Rooms[][] map = {
                {pinkRoom, entrance},
                {livingroom, studio}
        };
        int row = 0;
        int col = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the My Text Adventure Game (mTAG)");
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println("You just broke in an empty mansion. Find and open the vault");

    }

    public void gameLoop() {

    }

    public void exitGame() {

    }

}
