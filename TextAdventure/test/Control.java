import static org.junit.jupiter.api.Assertions.*;

import kyh.textadventure.*;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class Control {

    @Test
    public void testItem(){
        Item I = new Item("Hairpin", "A hairpin made of metal.");
        GrandTheftMansion G = new GrandTheftMansion();
        G.initialization();
        var Items = G.getMap()[2][0].getItems();
        Thing X = Items.thisItem("Hairpin");
        var V = Comparator.comparing(Thing::getName).thenComparing(Thing::getDescription).compare(I,X);
        assertEquals(V, 0);
    }

    @Test
    public void testWrongPassword(){
        int testInput = Safe.password(new String[]{"12454", "12"});
        assertEquals(0,testInput);
    }
    @Test
    public void testRightPassword(){
        int testInput = Safe.password(new String[]{"19871105", "2408"});
        assertEquals(1,testInput);
    }

    @Test
    public void testGetRoomName(){
        ItemsList tList = new ItemsList();
        Room T = new Room("tRoom", "test the room constructor", tList);
        String nameRoom = T.getRoomName();
        assertEquals("tRoom",nameRoom);
    }





}
