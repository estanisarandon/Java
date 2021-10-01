    package kyh.textadventure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void save(int row, int col){
        File file = new File("./save/save_game.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            String position = String.format("%d, %d", row, col);
            fileWriter.write(position);
            fileWriter.close();
            System.out.println("Game saved")
        }catch (IOException e) {
            System.out.println("Could not save the game");
        }


    }

    public static String load(){
        File file = new File("./save/save_game.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            String position = fileScanner.nextLine();
            fileScanner.close();
            return position;
        }

        } catch (IOException e){
            System.out.println("Could not load the game");
        }
        return null;
    }



    public static void main(String[] args) {

        //Welcome menu
        System.out.println("____________________________________");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("|       Grand Theft Mansion        |");
        System.out.println("|                                  |");
        System.out.println("|       1) Start new game          |");
        System.out.println("|       2) Load game               |");
        System.out.println("|       3) High scores             |");
        System.out.println("|       4) Exit                    |");
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        System.out.println("------------------------------------");

        System.out.print("> ");
        Scanner scmenu = new Scanner(System.in);
        int menuSelection = scmenu.nextInt();
        String playerName;

        if (menuSelection == 1) {
            //Define player name
            System.out.println("What is your name? ");
            Scanner scname = new Scanner(System.in);
            playerName = scname.nextLine();
        } else if (menuSelection == 2) {
            //Show High Scores
            System.out.println(HighScores.printRanking());
        } else if (menuSelection == 3) {
            //Load game
        } else {
            System.out.println("EXIT");
        }
    }

    public static void main(String[] args) {
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

        //Här börjar spelloopen
        boolean running;

        //Create a Chest with three items and place it in the entrance room in the map.
        Chest chest = new Chest("Chest", "A large chest containing other items");
        Item shield = new Item ("Shield", "A massive shield that works as a wall");
        Item potion = new Item ("Helath potion", "A potion that restores your health");
        Item sword = new Item ("Sword", "A very sharp and mighty sword left behind by Conan the Barbatian");
        chest.addItemsToChest(shield);
        chest.addItemsToChest(potion);
        chest.addItemsToChest(sword);
        entrance.setItem(chest):

        //Create an item and place it in the entrance.
        Item daggar = new Item("Dagger", "A snall but very deadly dagger.");
        entrance.setItem(daggar);


        while (running = true) {
            System.out.println("You are standing in a dark room. You can hear bats flying above you.");

            // 2. Läs in kommando från användaren
            System.out.print("> ");
            String command = input.nextLine();
            String[] commandParts = command.split(" ");

            /* 3. Dela upp kommandot i delar, varje ord blir en sträng i en array
                Vi delar upp det inmatade värdet vid varje mellanslag*/
            String[] commandParts = command.split(" ");

            // 4. Kollar vilket "huvudkommando" som angivits
            //    Dessa är:
            //      - go
            //      - quit
            //      - load
            //      - save
            if (commandParts[0].equalsIgnoreCase("go")) {    // Vi har angett go som kommando
                // Kontrollera att man har skrivit något efter go, alltså en riktning
                if (commandParts.length >= 2) {
                    // Kolla efter riktning
                    if (commandParts[1].equalsIgnoreCase("north")) {
                        row--;
                        // Kontrollera så vi inte hamnar utanför kartan
                        if (row < 0) {
                            row = 0;
                        } else if (commandParts[1].equalsIgnoreCase("south")) {
                            row++;
                            if (row >= map.length) {
                                row--;
                            }
                        } else if (commandParts[1].equalsIgnoreCase("east")) {
                            col++;
                            if (col >= map[row].length) {
                                col--;
                            }
                        } else if (commandParts[1].equalsIgnoreCase("west")) {
                            col--;
                            if (col < 0) {
                                col = 0;
                            }
                        } else {
                            System.out.println("Going " + commandParts[1]);
                        }
                        //else {
                        // System.out.println("You can't go without any direction");
                    }
                }
            }

            if(command.equalsIgnoreCase("look at item")){
                String itemDescription = map[row][col].getItemDescription();
                System.out.println(itemDescription);
            }

            if (command.equalsIgnoreCase("save")) {
                save(row, col);
            }
            if (command.equalsIgnoreCase("load")) {
                String position = load();
                if(position != null){
                    String[] pos = position.split(", ");
                    int oldRow = row;
                    int oldCol = col;
                    row = Integer.parseInt(pos[0]) ;
                    col = Integer.parseInt(pos[1]);
                    if(row >= map.length) {
                        System.out.println("Error reading row coordinates from file. Are you cheating?");
                        row = oldRow;
                        col = oldCol;
                    }
                    else{
                        if(col >= map[row].length){
                            System.out.println("Error reading col coordinates from file. Are you cheating?");
                            row = oldRow;
                            col = oldCol;
                        }
                    }
                }
            }
            if (command.equalsIgnoreCase("quit")) {
                running = false;
            }

            System.out.println("Thanks for playing TAG");
        }
    }

