package kyh.textadventure;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GrandTheftMansion {

    Scanner input = new Scanner(System.in);
    //Map size & Coordinates
    int row = 1;
    int col = 1;
    int rowSize;
    int colSize;
    Room[][] map;
    boolean running = true;
    ArrayList itemsList = new ArrayList();
    ArrayList extraItems = new ArrayList();
    ArrayList objectsList = new ArrayList();
    ArrayList playerBag = new ArrayList();


    public void initialization(){

        //Room mindRoom = new Room("Mind room", "This is a room full with memories.");
        Room pinkRoom = new Room("Pink room", "This is a room with pink walls filled with pink furniture.");
        Room studio = new Room("Studio", "This room has all walls covered with books and a desk in the middle.");
        Room kitchen = new Room("Kitchen", "This is a kitchen.");
        Room livingroom = new Room("Living room", "This is a room with a TV.");
        Room entrance = new Room("The entrance", "This is the entrance hall. There is a stair going to the second floor.");
        Room vaultRoom = new Room("Vault room", "This is room has a vault.");
        Room room1 = new Room("Room 1", "This is a room with just a single bed.");
        Room mainRoom = new Room("Main room", "This is the main room with double bed and a walking closet.");
        Room room2 = new Room("Room 2", "This is an empty room");

        map =new Room[][] {
            {pinkRoom, studio, kitchen},
            {livingroom, entrance, vaultRoom},
            {room1, mainRoom, room2}
        };

        this.rowSize=map[0].length;
        this.colSize=map.length;

        Item grog = new Item("Bottleof Grog", "A dilution of rum with water, with lime and sugar added.");
        kitchen.setItem(grog);
        itemsList.add(grog);
        Item note = new Item("Note", "A small piece of paper with some annotations.");
        entrance.setItem(note);
        itemsList.add(note);
        Item hairpin = new Item("Bobby pin", "A type of hairpin made of metal.");
        room1.setItem(hairpin);
        itemsList.add(hairpin);
        Item diary = new Item("Personal diary", "A small book with person's experiences, thoughts, and feelings.");
        studio.setItem(diary);
        itemsList.add(diary);
        Item scissors = new Item("Scissors", "Small but very sharp paper scissors.");
        studio.setItem(scissors);
        itemsList.add(scissors);
        Item knife = new Item("Butter knife", "A blunt knife used for cutting or spreading butter.");
        kitchen.setItem(knife);
        itemsList.add(knife);
        Item key = new Item("Key", "A small piece of shaped metal with incisions cut to fit the wards of a particular lock.");
        room2.setItem(key);
        itemsList.add(key);

        //This item will replace the picture_frame
        Item photo = new Item("Photo", "There is something written behind: Year 1987.");
        extraItems.add(photo);
        //This item will appear after looking into the wallet
        Item paper = new Item("Paper scrap", "It says YYYY-MM-DD-08.. \n Looks like it's missing the last part.");
        extraItems.add(paper);

        //This objects can not be collected.
        Item a_safe = new Item("A safe", "A strong fireproof cabinet with a complex lock, used for the storage of valuables.");
        vaultRoom.setItem(a_safe);
        objectsList.add(a_safe);
        Item fireplace = new Item("A fireplace", "A place to make a fire. Looks like there is something in the back, but I can't see well through the fire.");
        livingroom.setItem(fireplace);
        objectsList.add(fireplace);
        Item door = new Item("A door", "This door seams to be locked. I wonder what kind of room is on the other side.");
        pinkRoom.setItem(door);
        objectsList.add(door);
        Item instructions = new Item("Vaults instructions", "YYYY-MM-DD-****.");
        vaultRoom.setItem(instructions);
        objectsList.add(instructions);

        Container suitcase = new Container("Suitcase", "A case used for carrying clothes and other personal possessions.");
        Item wallet = new Item("Wallet", "A pocket-sized, flat, folding holder for money and plastic cards.");
        itemsList.add(wallet);
        Item pen = new Item("Pen", "An instrument for writing.");
        itemsList.add(pen);
        Item picture_frame = new Item("Picture frame", "Has a picture of a dog wearing a suit and a hat, and a white rabbit. They look kinda familiar...");
        itemsList.add(picture_frame);
        suitcase.addItemsToContainer(wallet);
        suitcase.addItemsToContainer(pen);
        suitcase.addItemsToContainer(picture_frame);
        mainRoom.setItem(suitcase);

    }

    public String[] readUserInput(){
        System.out.print("> ");
        String commandInput = input.nextLine();
        String[] commandParts = commandInput.split(" ");
        return commandParts;
    }

    //Setters & getters
    public void setCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setRow(int newRow) {
        this.row = newRow;
    }
    public void setCol(int newCol) {
        this.col = newCol;
    }
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
    }
    public int getRowSize() {
        return this.rowSize;
    }
    public int getColSize() {
        return this.colSize;
    }

    public void run() {
        //Welcome menu
        MainMenu mainMenuInput = new MainMenu();
        int menuInput = mainMenuInput.runMenu();

        //Switcher
        switch (menuInput) {
            case 1:
                System.out.println("Loading..."); //Start game
                //Runtime.getRuntime().exec("cls");
                break;
            case 2:
                SaveAndLoad.load(); //Load game
                break;
            case 3:
                System.out.println("Show Hall of Fame"); // HallOfFame.ranking();
                mainMenuInput.runMenu();
                break;
            case 4:
                this.running = false;
                break;
        }

        Commands commands = new Commands();
        ArrayList playerBag = new ArrayList();


        while (this.running) {
            // 1. Skriv ut i vilket rum vi är i
            System.out.println(map[row][col].toString());

            // 2. Läs in kommando från användaren
            System.out.println("Actions: [go][look att][use][pick up][Items]  [save][quit]");
            String[] commandParts = readUserInput();
            String command = commandParts[0];

            // 4. Kollar vilket "huvudkommando" som angivits
            //    Dessa är:
            //      - go        - pick up
            //      - look at   - use
            //
            if (command.equalsIgnoreCase("go")) {
                if (commandParts.length >= 2) { // Kontrollera att man har skrivit något efter go, alltså en riktning
                    if(commandParts[1].equalsIgnoreCase("north")) {
                        commands.north();
                    } else if (commandParts[1].equalsIgnoreCase("south")){
                        if(row ==1 || row==2){
                            System.out.println("You can't go south.");
                        } else {
                            row++;
                            if(row >= map.length){
                                row--;
                            }
                        }
                    }
                    } else if (commandParts[1].equalsIgnoreCase("east")){
                        commands.east();
                    } else if (commandParts[1].equalsIgnoreCase("west")){
                        commands.west();
                    } else if (commandParts[1].equalsIgnoreCase("up")){
                        commands.up();
                    } else if (commandParts[1].equalsIgnoreCase("down")) {
                        commands.down();
                    }else {
                        System.out.println("You can't go without a direction");
                    }
                }
            }

            if (command.equalsIgnoreCase("items")){
                System.out.println(playerBag);
            }

            if (command.equalsIgnoreCase("look")) {
                String itemDescription = map[this.row][this.col].getItemDescription();
                System.out.println(itemDescription);
            }

            /*if (command.equalsIgnoreCase("use")) {
                String useItem = commandParts[1];
                if () {
                    //grog, bobby pin, pen, picture frame, bobby pen (bobby pin + pen)
                }*/

            if (command.equalsIgnoreCase("pick")) {
                String itemToPick = commandParts[2].toLowerCase();
                if(itemsList.contains(itemToPick)){
                    playerBag.add(itemToPick);
                    System.out.println("You have picked up a " + itemToPick);
                } else {
                    System.out.println("You can't pick up that");
                }
            }

            switch (command.toLowerCase()) {
                case "save":
                    SaveAndLoad.save(this.row, this.col);
                    break;
                case "load":
                    SaveAndLoad.load();
                    break;
                case "quit":
                    running = false;
                    break;

            }
        }
    }

    public void quit() {
        System.out.println("Thank you for playing Grand Theft Mansion");
    }

