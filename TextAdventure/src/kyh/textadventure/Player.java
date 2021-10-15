package kyh.textadventure;

import java.util.ArrayList;

public class Player {

    ArrayList bag = new ArrayList();
    ArrayList deletedItems = new ArrayList();

    public player() {
        String name;
    }

    public void addItemToBag(String addItem){
        bag.add(addItem);
    }

    public void deletItem(){

    }

    public void printBag(){
        System.out.println(bag);
    }
}
