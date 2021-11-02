package kyh.textadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveAndLoad {

    //Read script
    public static void read(String s){
        File file = new File("./Files/Script.txt");
        String start = "";
        String output="";
        try {
            Scanner fileScanner = new Scanner(file);
            boolean run = true;
            while(!s.equals(start)){
                start = fileScanner.findInLine(s);
                fileScanner.nextLine();
            }
            while (run == true) {
                output += fileScanner.nextLine() + "\n";
                if(output.contains("***")){
                    run=false;
                }
            }
            System.out.println(output);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the script");
        }
    }

    //Save game
    public static void save(int row, int col) {
        File file = new File("./Files/saved_game.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            String position = String.format("%d, %d", row, col);
            fileWriter.write(position);
            fileWriter.close();
            System.out.println("The game is saved");
        } catch (IOException e) {
            System.out.println("Could not save the game");
        }
    }

    //Load game
    public static void load(GrandTheftMansion game) {
        File file = new File("./Files/saved_game.txt");
        String position = "";
        try {
            Scanner fileScanner = new Scanner(file);
            position = fileScanner.nextLine();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not load game");
        }

        if (position != null) {
            String[] pos = position.split(", ");
            int row = Integer.parseInt(pos[0]);
            int col = Integer.parseInt(pos[1]);
            game.setCoordinates(row, col);
        }
            /*if (row >= GrandTheftMansion.getRowSize()) {
                System.out.println("Error reading row coordinates from file. Are you cheating?");
                GrandTheftMansion.setCoordinates(1,1);
            } else {
                if (col >= GrandTheftMansion.getColSize()) {
                    System.out.println("Error reading row coordinates from file. Are you cheating?");
                    GrandTheftMansion.setCoordinates(1,1);
                }
                int[] returnValue ={row, col};
            return returnValue;
            }*/
    }
}
