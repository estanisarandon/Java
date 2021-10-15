package kyh.textadventure;

import java.util.Scanner;

public class GrandTheftMansion {

    Scanner input;
    //Map size & Coordinates
    int row = 1;
    int col = 1;
    int rowSize = 0;
    int colSize = 0;
    Room[][] map;
    boolean running = true;


    public void initialization(){

        input = new Scanner(System.in);
        Player player = new Player();


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

        this.rowSize =map[0].length;
        this.colSize =map.length;

        Item grog = new Item("Bottle of Grog", "A dilution of rum with water, with lime and sugar added.", false);
        kitchen.setItem(grog);
        Item note = new Item("Note", "A small piece of paper with some annotations.", false);
        entrance.setItem(note);
        Item bobby_pin = new Item("Bobby pin", "A type of hairpin made of metal.", false);
        room1.setItem(bobby_pin);
        Item personal_diary = new Item("Personal diary", "A small book with person's experiences, thoughts, and feelings.", false);
        studio.setItem(personal_diary);
        Item scissors = new Item("Scissors", "Small but very sharp paper scissors.", false);
        studio.setItem(scissors);
        Item butter_knife = new Item("Butter knife", "A blunt knife used for cutting or spreading butter.", false);
        kitchen.setItem(butter_knife);
        Item key = new Item("Key", "A small piece of shaped metal with incisions cut to fit the wards of a particular lock.", false);
        room2.setItem(key);

        //This item will replace the picture_frame
        Item photo = new Item("Photo", "There is something written behind: Year 1987.", false);
        //This item will appear after looking into the wallet
        Item paper_scrap = new Item("Paper scrap", "It says YYYY-MM-DD-08.. \n Looks like it's missing the last part.", false);

        //This objects can not be collected.
        Item a_safe = new Item("A safe", "A strong fireproof cabinet with a complex lock, used for the storage of valuables.", true);
        vaultRoom.setItem(a_safe);
        Item fireplace = new Item("A fireplace", "A place to make a fire. Looks like there is something in the back, but I can't see well through the fire.", true);
        livingroom.setItem(fireplace);
        Item door = new Item("A door", "This door seams to be locked. I wonder what kind of room is on the other side.", true);
        pinkRoom.setItem(door);
        Item instructions = new Item("Vaults instructions", "YYYY-MM-DD-****.", true);
        vaultRoom.setItem(instructions);

        Container messenger_bag = new Container("Messenger bag", "One of those courier bags with enough space for a journey.");
        entrance.setItem(messenger_bag);

        Container suitcase = new Container("Suitcase", "A case used for carrying clothes and other personal possessions.");
        Item wallet = new Item("Wallet", "A pocket-sized, flat, folding holder for money and plastic cards.", false);
        Item pen = new Item("Pen", "An instrument for writing.", false);
        Item picture_frame = new Item("Picture frame", "Has a picture of an old couple.", false);
        suitcase.addItemsToContainer(wallet);
        suitcase.addItemsToContainer(pen);
        suitcase.addItemsToContainer(picture_frame);
        mainRoom.setItem(suitcase);
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        String position = null;

        //Welcome menu
        MainMenu mainMenuInput = new MainMenu();
        mainMenuInput.printMenu();
        mainMenuInput.runMenu();

        //Switcher
        switch (mainMenuInput.runMenu()) {
            case 1:
                //Start game
                break;
            case 2:
                //Load game
                int[] pos = SaveAndLoad.load();
                break;
            case 3:
                System.out.println("Show Hall of Fame");
                // HallOfFame.ranking();
                break;
            case 4:
                this.running = false;
                break;
        }

        // Clean screen
        Runtime.getRuntime().exec("cls");

        Commands commands = new Commands();
        String[] commandParts = readUserInput();
        String command = commandParts[0];
        Player player = new Player();
        Item item = new Item();


        while (this.running) {
            // 1. Skriv ut i vilket rum vi är i
            System.out.println(map[row][col].toString());

            // 2. Läs in kommando från användaren
            System.out.println("Actions: [go][look att][use][pick up][Items bag]  [save][quit]");

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
                        commands.south();
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

            if(command.equalsIgnoreCase("items")){
                player.printBag();
            }

            if (command.equalsIgnoreCase("look")) {
                //if(messenger_bag.contains("commandParts[2]"){
                String itemDescription = map[this.row][this.col].getItemDescription();
                System.out.println(itemDescription);
            }

            /*if (command.equalsIgnoreCase("use")) {
                String useItem = commandParts[1];
                if () {
                    //grog, bobby pin, pen, picture frame, bobby pen (bobby pin + pen)
                }*/

            if (command.equalsIgnoreCase("pick")) {
                String pickeditem = commandParts[2].equalsIgnoreCase();
                if(item.)
                player.addItemToBag(item);
                }

            switch (command.equalsIgnoreCase()) {
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

    public String[] readUserInput(){
        System.out.print("> ");
        String commandInput = input.nextLine();
        String[] commandParts = commandInput.split(" ");
        return commandParts;
    }

    /*public void menuSwitch() {

    }*/

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

}