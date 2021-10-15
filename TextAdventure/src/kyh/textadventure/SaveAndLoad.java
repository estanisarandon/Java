package kyh.textadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveAndLoad {

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
    public static int[] load() {
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
            int[] returnValue ={row, col};
            return returnValue;

            /*GrandTheftMansion.setCoordinates(row, col);

            if (row >= GrandTheftMansion.getRowSize()) {
                System.out.println("Error reading row coordinates from file. Are you cheating?");
                GrandTheftMansion.setCoordinates(1,1);
            } else {
                if (col >= GrandTheftMansion.getColSize()) {
                    System.out.println("Error reading row coordinates from file. Are you cheating?");
                    GrandTheftMansion.setCoordinates(1,1);
                }
            }*/
        }

        return null;
    }
}
