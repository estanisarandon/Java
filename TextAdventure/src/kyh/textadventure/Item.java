package kyh.textadventure;

public class Item {
    protected String type;
    protected String description;
    protected boolean object;

    public Item(String inType, String inDescription, boolean inobject) {
        type = inType;
        description = inDescription;
        object =  inobject;
    }

    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public boolean getObject(){return object; }

    // returns a string representation of the item.
    @Override
    public String toString() {
        String itemDescription = type;
        itemDescription = itemDescription + "\n";
        itemDescription = itemDescription + description;
        return itemDescription;
    }
}
