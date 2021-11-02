package kyh.textadventure;

import java.util.ArrayList;

// Chest that is able to contain other items.
public class Container extends ArrayList<Item> {




    /*public ArrayList<Item> inventory = new ArrayList<Item>();
    int maxSize = 4;

    Player player = new Player();

    // Create a new chest with the same information as a default item.
    public Container(String inType, String inDescription) {super(inType, inDescription);
    }

    // if the chest is not full, add another item to the chest.
    public void addItemsToContainer(Item inItems) {
        if(inventory.size() < maxSize) {
            inventory.add(inItems);
        }
    }

    public void removeItems(Item inItem){
        inventory.remove(inItem);
    }

    public ArrayList<Item> containerHas(Container C){
        //int i = player.bag.indexOf(C);
        //Container
        return C.inventory;
    }

    @Override
    public String toString() {
        String itemDescription = type + "\n";
        itemDescription = itemDescription + description;
        itemDescription = "Chest contains:\n";

        if(inventory.size()==0) {
            itemDescription = itemDescription + "The chest is empty";
        } else {
            for(int i=0;i<inventory.size();i++) {
                itemDescription = itemDescription + inventory.get(i).toString() + "\n";
            }
        }
        return itemDescription;
    }*/
}
