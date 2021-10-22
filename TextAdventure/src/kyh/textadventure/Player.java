package kyh.textadventure;

import java.util.HashMap;

public class Player {

    private HashMap<String, String> bag = new HashMap<String, String>();


    public void addItem(String inName, String inDescription){
        bag.put(inName, inDescription);
    }

    public void printBag() {
        boolean emptyBag=this.bag.isEmpty();
        if(emptyBag==true){
            System.out.println("You haven't collect anything yet.");
        } else {
            System.out.println("You have collected: ");
            for (String bag : bag.keySet()) {
                System.out.println(bag);
            }
        }
    }

    public void lookItemBag(String inName){
        String item = bag.get(inName);
        System.out.println(item);
    }

    /*public boolean isInBag (String inName){
        if(inName : bag.keySet()){
            return true;
        }
    }*/
}
