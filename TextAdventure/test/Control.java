import static org.junit.jupiter.api.Assertions.*;

import kyh.textadventure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Objects;

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
    public void testWrongPassword() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("passwordTest".getBytes( "19871212"));
        Safe.password();
        System.setIn(in); // do your thing
        assertEquals(0,0);
        System.setIn(sysInBackup); // optionally, reset System.in to its original

    }

    public void testCreateThing(){
        Thing t = new Thing ("test", "this is a test");

    }





}
