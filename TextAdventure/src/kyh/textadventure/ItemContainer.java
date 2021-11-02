package kyh.textadventure;

public class ItemContainer extends Thing{

    //ItemContainer and ItemsList class facilitates the process of moving items around.

    private ItemsList itemsList = new ItemsList();
    public ItemContainer(String itName, String itDescription, ItemsList ilist){
        super(itName, itDescription);
        itemsList = ilist;
    }
    public ItemsList getItems(){
        return itemsList;
    }

}
