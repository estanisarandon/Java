package kyh.textadventure;

public class Room {

    /* We have variables for name, description and other parameters
    since this is necessary to determine the players current state in the world.*/
    private String name;
    private String description;
    private Item item;
    private Item object;

    // Store the default values for name and description of a room.
    public Room(String inName, String inDescription) {
        name = inName;
        description = inDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Return the description of an item.
    public String getItemDescription() {
        // if item is not null (i.e. we have already stored an item in item.
        if(item != null) {
            return item.toString();
        } else {    // else if item is null. i.e. there is no item stored in item (by adding iten through the function setItem.
            return "No item found";
        }
    }

    public String getItDescript() {
        String I = "";
        String O = "";
        if(item != null) {
            I = item.getDescription();
        }
        if(object != null) {
            O = object.getDescription();
        }
        return I + "\n" +  O;

    }

    public void setName(String newName) {
        name = newName;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    // Store a created item in the item variable in room.
    public void setItem(Item inItem) {
        item = inItem;
    }
    public void setObject(Item inObject){
        object = inObject;
    }

    public void removeItem(){
        item=null;
    }

    // Create a string representation of a room to show in the main game loop.
    @Override
    public String toString() {
        String roomString = "\n" + getName() + "\n" + getDescription() + "\n";   // roomstring: "A hall" + "this is a description of a hall.
        roomString = roomString + "\n" + "Items             Objects" +
                "\n---------------   ---------------\n";             // roomstring: "A hall" + "this is a ..." + "Items..."

        // We need ot make sure that there is an item in the room before we try to call
        // a function in that item.
        if(item != null) {
            roomString = roomString + "A " + item.getType();
        }
        if(object != null) {
            roomString = roomString + "                  " + "A " + object.getType();
        }

        return roomString;
    }


}
