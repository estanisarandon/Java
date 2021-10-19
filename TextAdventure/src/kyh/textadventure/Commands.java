package kyh.textadventure;

public class Commands {

    //      - go        - pick up
    //      - look at   - use
    GrandTheftMansion gtm = new GrandTheftMansion();
    int row = gtm.getRow();
    int col = gtm.getCol();
    int mapSize = gtm.getRowSize();


    /*public void south(){
        if(row ==1 || row==2){
            System.out.println("You can't go south.");
        } else {
            gtm.setRow(row++);
            if(row >= mapSize) {
                gtm.setRow(row--);
            }
        }
    }*/
    public void north(){
        if(row==0 || row==2){
            System.out.println("You can't go north");
        } else{
            gtm.setRow(row--);
            if(row < 0) {
                gtm.setRow(0);
            }
        }
    }
    public void east(){
        if(col==2){
            System.out.println("You can't go east");
        } else{
            gtm.setCol(col++);
            if(col >= mapSize) {
                gtm.setCol(col--);
            }
        }
    }
    public void west(){
        if(col==0){
            System.out.println("You can't go west");
        } else{
            gtm.setCol(col--);
            if(col < 0) {
                gtm.setCol(0);
            }
        }
    }
    public void up(){
        if(row==1 && col==1){
            gtm.setCol(0);
            gtm.setRow(2);
        } else {
            System.out.println("You can not go up.");
        }
    }
    public void down(){
        if(row==2){
            gtm.setCol(1);
            gtm.setRow(1);
        } else{
            System.out.println("You can not go down.");
        }
    }
}
