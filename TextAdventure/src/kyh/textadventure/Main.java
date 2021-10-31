package kyh.textadventure;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        /*int row = 1;
        int col = 1;
        String[] names;

        SerializableObject sc = new SerializableObject(row, col, names);

        saveData(so);*/

        GrandTheftMansion gtm = new GrandTheftMansion();
        gtm.initialization();
        gtm.run();
        gtm.quit();
    }

    /*private static void saveDate(SerializableObject so){
        FileOutputStream fileOut = null;
        try{
            fileOut = new FileOutputStream ("./Files/saved_game.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(so);
            objectOut.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static SerializableObject loadData(){
        try{
            FileInputStream fileIn = new FileInputStream("./Files/saved_game.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            SerializableObject so = (SerializableObject) objectIn.readObject();
            so = (SerializableObject) o
            objectIn.readObject(so);
            objectIn.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    }*/
}
