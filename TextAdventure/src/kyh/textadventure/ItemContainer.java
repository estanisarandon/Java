package kyh.textadventure;

public class ItemContainer extends Thing{

    private ItemsList itemsList = new ItemsList();

    public ItemContainer(String itName, String itDescription, ItemsList ilist){
        super(itName, itDescription);
        itemsList = ilist;
    }

    public ItemsList getItems(){
        return itemsList;
    }

    public void setItems(ItemsList addItemList){
        this.itemsList = addItemList;
    }
}
