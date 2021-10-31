package kyh.textadventure;

public class Room extends ItemContainer{

    // Store the default values for name and description of a room and a list of things that can contain.
    public Room(String inName, String inDescription, ItemsList ilist) {
        super(inName, inDescription, ilist);
    }

    // Getters
    public String getRoomName(){
        return getName();
    }
    public String getDescription() {
        return String.format("%d. %d.", getName(), getDescription()) + "\nThis room contains:\n" + getItems().describeItems();
    }

    // Create a string representation of a room to show in the main game loop.
//    @Override
//    public String toString() {
//        //String roomString = "\n" + getName() + "\n" + getDescription() + "\n";   // roomstring: "A hall" + "this is a description of a hall.
//        //roomString = roomString + "\n" + "Things in this room:" + getItems();
//        //return roomString;
//
//        return getDescription();
//    }
}
