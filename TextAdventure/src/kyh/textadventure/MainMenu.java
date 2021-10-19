package kyh.textadventure;

import java.util.Scanner;

public class MainMenu {

    GrandTheftMansion gtm = new GrandTheftMansion();

    public static void printMenu() {

        System.out.println("____________________________________");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("|       Grand Theft Mansion        |");
        System.out.println("|                                  |");
        System.out.println("|       1) Start new game          |");
        System.out.println("|       2) Load game               |");
        System.out.println("|       3) Hall of Fame            |");
        System.out.println("|       4) Exit                    |");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("------------------------------------");
    }

    public int runMenu() {
        int userInput=0;

        do{
            printMenu();
            System.out.print("> ");
            Scanner scmenu = new Scanner(System.in);
            userInput = scmenu.nextInt();

            if (userInput > 0 && userInput <5){
                return(userInput);
            } else{
                System.out.println("Input not valid. Please select a number from the menu.");
            }
        }while (true);
    }

}
