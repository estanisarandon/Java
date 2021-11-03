package kyh.textadventure;

import java.util.ArrayList;


public class ItemsList extends ArrayList<Thing>{

    public String describeItems(){
        String s = "";
        if (this.size()==0){
            s = "nothing.";
        }else{
            for(Thing t : this){
                s = s + "\n" + t.getName() + ": " + t.getDescription();
            }
        }
        return s;
    }
    public Thing thisItem(String inName){
        Thing item = null;
        String itemName = "";
        String name = inName.toLowerCase();
        for(Thing t : this){
            itemName = t.getName().toLowerCase();
            if(itemName.equals(name)){
                item = t;
            }
        }
        return item;
    }
    public String namesIL (){
        String s = "";
        if (this.size()==0){
            s = "empty.";
        }else{
            for(Thing t: this){
                s = s + "\n" + t.getName();
            }
        }
        return s;
    }
    public String getThingsName(){
        String s = "";
        if (this.size()==0){
            s = "nothing.";
        }else{
            for(Thing t : this){
                s = s + "\n" + t.getName();
            }
        }
        return s;
    }
}
