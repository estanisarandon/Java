package kyh.textadventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Player extends ItemContainer {

    public Player(String name, String description, ItemsList ilist){
        super(name, description, ilist);
    }
}
