package kyh.textadventure;

public class Commands {

    //      - go        - pick up
    //      - look at   - use
    GrandTheftMansion gtm = new GrandTheftMansion();
    int row = gtm.getRow();
    int col = gtm.getCol();
    int newrow = gtm.setRow();
    int newcol = gtm.setCol();
    int mapSize = gtm.getRowSize();


    public void south(){
        if(row ==1){
            System.out.println("You can't go south.");
        } else {
            newrow++;
            if(row >= mapSize) {
                newrow--;
            }
        }
    }

    public void north(){
        if(row==2){
            System.out.println("You can't go north");
        } else{
            newrow--;
            if(row < 0) {
                newrow = 0;
            }
        }
    }

    public void east(){
        if(col==2){
            System.out.println("You can't go east");
        } else{
            newcol++;
            if(col >= mapSize) {
                newcol--;
            }
        }
    }

    public void west(){
        if(col==0){
            System.out.println("You can't go west");
        } else{
            newcol--;
            if(col < 0) {
                newcol=0;
            }
        }
    }

    public void up(){
        if(row==1 && col == 1){
            newcol=0;
            newrow=2;
        } else {
            System.out.println("You can not go up.");
        }
    }

    public void down(){
        if(row==2){
            newcol=1;
            newrow=1;
        } else{
            System.out.println("You can not go down.");
        }
    }






    }
