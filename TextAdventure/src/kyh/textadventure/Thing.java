package kyh.textadventure;

public class Thing {

    // All rooms, items / objects and player are extensions of the Thing class

    private String name;
    private String description;

    public Thing (String inName, String inDescription){
        name=inName;
        description=inDescription;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setName(String inName) {
        name = inName;
    }
    public void setDescription(String inDescription) {
        description = inDescription;
    }
}
