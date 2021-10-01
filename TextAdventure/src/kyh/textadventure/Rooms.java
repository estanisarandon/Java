package kyh.textadventure;

public class Rooms {
    // We have variables for name, description and other parameters since this is necessary to determine the players
    // current state in the world.
    private String name;
    private String description;
    //public int numberOfDoors = 2;

    //Store the default values for name and description of room.
    public Rooms(String inName, String inDescription) {
        name = inName;
        description = inDescription;
    }


    public void setName(String newName){

        name = newName;
    }

    public void setDescription(String newDescription){

        description = newDescription;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }

    //Return the description of an item.
    public String getItemDescription(){
        //if item is not null ( i.e. we have already stored an item in item.
        if(item != null){
            return item.toString();
        } else { //else if item is null i.e. there is no item stored in the item
            // (by adding item through the function setItem)
            return "No item found";
        }
    }

    public void setItem(Item inItem) {
        item = inItem;
    }

    @Override
    public String toString(){
        String roomString = getName() + "\n";
        roomString = roomString + getDescription() + "\n";
        roomString = "Items\n---------------\n";

        //We need to make sure that there is a item in the room before we try to call
        // a function in that item.
        if(item != null){
            roomString = roomString + item.getType();
        }

        return roomString;

    }

}
