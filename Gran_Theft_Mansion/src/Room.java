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
                + "\n" + "This room contains: \n" + getItems().getThingsName();
    }
    public static void printExits(int R, int C){
        String Cord = "" + R + C;
        switch (Cord) {
            case "00" -> System.out.println("Directions: S & E");
            case "01" -> System.out.println("Directions: W, S & E");
            case "02" -> System.out.println("Directions: W & S");
            case "10" -> System.out.println("Directions: N & E");
            case "11" -> System.out.println("Directions: W, N, E & UP");
            case "12" -> System.out.println("Directions: W & N");
            case "20" -> System.out.println("Directions: E & DOWN");
            case "21" -> System.out.println("Directions: W, E & DOWN");
            case "22" -> System.out.println("Directions: W & DOWN");
        }
    }
}
