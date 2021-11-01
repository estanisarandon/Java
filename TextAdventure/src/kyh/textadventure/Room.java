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
    public String getRoomDescription() {
        return String.format("%s: %s", getName(), getDescription())
                + "\n" + "This room contains: \n" + getItems().describeItems();
    }

}
