package kyh.textadventure;

import java.util.Scanner;

public class MainMenu {

    public static void printMenu() {

        System.out.println("____________________________________");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("|       GRAND THEFT MANSION        |");
        System.out.println("|                                  |");
        System.out.println("|       1) Start new game          |");
        System.out.println("|       2) Load game (coming soon) |");
        System.out.println("|       3) Credits                 |");
        System.out.println("|       4) Exit                    |");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("------------------------------------");
    }
    public int runMenu() {
        int userInput;
        printMenu();
        System.out.print("> ");
        Scanner scmenu = new Scanner(System.in);
        userInput = scmenu.nextInt();
        return userInput;
    }
    public void Credits(){
        System.out.println("____________________________________");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("|       GRAND THEFT MANSION        |");
        System.out.println("|                                  |");
        System.out.println("|    Programmed and produced by    |");
        System.out.println("|                                  |");
        System.out.println("|       Estanislao Sarandón        |");
        System.out.println("|              2021                |");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("------------------------------------");
    }

}
