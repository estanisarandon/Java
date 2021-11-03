package kyh.textadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {

    //Read script
    public static void read(String s){
        File file;
        file = new File("./Gran_Theft_Mansion/Files/Script.txt");
        String start = "";
        String output="";
        try {
            Scanner fileScanner = new Scanner(file);
            boolean run = true;
            while(!s.equals(start)){
                start = fileScanner.findInLine(s);
                fileScanner.nextLine();
            }
            while (run) {
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
}
