package kyh.textadventure;


import java.util.*;


public class GrandTheftMansion {

    Scanner input = new Scanner(System.in);
    //Map size & Coordinates
    int row = 1;
    int col = 1;
    Room[][] map;

    //Player 1
    String playerName="player1";
    ItemsList playerBag = new ItemsList();
    Player player = new Player(playerName, "",playerBag);

    //Array Lists
    public ArrayList<String> containers = new ArrayList<String>();
    public ArrayList<String> objects = new ArrayList<String>(); // List of all objects that can not be picked up
    public ArrayList<String> sorry = new ArrayList<String>(); // List of fail random answers
    public ArrayList<String> actions = new ArrayList<String>(); // List of possible actions

    //Item containers
    ItemsList suitcaseList = new ItemsList();
    ItemContainer suitcase = new ItemContainer("Suitcase", "A case used for carrying clothes and other personal possessions. Seems to be full of stuff.", suitcaseList);
    ItemsList walletList = new ItemsList();
    ItemContainer wallet = new ItemContainer("Wallet", "A pocket-sized, flat, folding holder for money and plastic cards.", walletList);

    public String getRandomAnswer(){
        Random random = new Random();
        return sorry.get(random.nextInt(sorry.size()));
    }
    public void initialization() {

        //Create item list to each room
        ItemsList pinkRoomList = new ItemsList();
        ItemsList studioList = new ItemsList();
        ItemsList kitchenList = new ItemsList();
        ItemsList livingroomList = new ItemsList();
        ItemsList entranceList = new ItemsList();
        ItemsList vaultRoomList = new ItemsList();
        ItemsList room1List = new ItemsList();
        ItemsList mainRoomList = new ItemsList();
        ItemsList room2List = new ItemsList();

        //Room mindRoom = new Room("Mind room", "This is a room full with memories.");
        Room pinkRoom = new Room("Pink room", "This is a room with pink walls filled with pink furniture.", pinkRoomList);
        Room studio = new Room("Studio", "This room has all walls covered with books and a desk in the middle.", studioList);
        Room kitchen = new Room("Kitchen", "This is a kitchen.", kitchenList);
        Room livingroom = new Room("Living room", "This is a room with a TV.", livingroomList);
        Room entrance = new Room("The entrance", "This is the entrance hall. There is a stair going to the second floor.", entranceList);
        Room vaultRoom = new Room("Vault room", "There is a big safe in the middle of the room.", vaultRoomList);
        Room room1 = new Room("Room 1", "This is a room with just a single bed.", room1List);
        Room mainRoom = new Room("Main room", "This is the main room with double bed and a walking closet.", mainRoomList);
        Room room2 = new Room("Room 2", "This is an empty room", room2List);

        //Map creation
        map = new Room[][]{
                {pinkRoom, studio, kitchen},
                {livingroom, entrance, vaultRoom},
                {room1, mainRoom, room2}
        };

        //Items creation
        Item grog = new Item("Bottle", "A dilution of rum with water, with lime and sugar added. The label says: Monkey Island Grog.");
        pinkRoomList.add(grog);
        Item note = new Item("Note", "A small piece of paper with some annotations.");
        entranceList.add(note);
        Item hairpin = new Item("Hairpin", "A hairpin made of metal.");
        room1List.add(hairpin);
        Item knife = new Item("Knife", "A blunt knife used for cutting or spreading butter.");
        kitchenList.add(knife);
        Item picture = new Item("Picture", "Has a photo of a dog wearing a suit and a hat, and a white rabbit. They look kinda familiar...\n" + "There is something written behind: Year 1987.");
        studioList.add(picture);
        Item pen = new Item("Pen", "An instrument for writing.");
        suitcaseList.add(pen);
        Item key = new Item("Key", "A small piece of shaped metal with incisions cut to fit the wards of a particular lock.");
        suitcaseList.add(key);
        Item diary = new Item("Diary", "A small book with person's experiences, thoughts, and feelings.");
        suitcaseList.add(diary);
        mainRoomList.add(suitcase);
        Item paper = new Item("Paper", "It says YYYY-MM-DD-08.. \n Looks like it's missing the last part.");
        walletList.add(paper);
        room2List.add(wallet);

        //These objects can not be collected.
        Object safe = new Object("Safe", "A strong fireproof cabinet with a complex lock, used for the storage of valuables.\n Safe instructions: YYYY-MM-DD-****");
        vaultRoomList.add(safe);
        Object fireplace = new Object("Fireplace", "A place to make a fire. Looks like there is something in the back, but I can't see well through the fire.");
        livingroomList.add(fireplace);
        Object door = new Object("Door", "This door seams to be locked. I wonder what kind of room is on the other side?");
        pinkRoomList.add(door);
        Object window = new Object("Window", "An opening in the wall that allow people to see out.");
        room2List.add(window);

        //Sorry not sorry
        sorry.add("Sorry, I don't understand what are you saying.");
        sorry.add("No hablo español.");
        sorry.add("What did you just say?");
        sorry.add("I can't process that order.");

        //Containers list
        containers.add("suitcase");
        containers.add("wallet");

        //Objects list
        objects.add("fireplace");
        objects.add("door");
        objects.add("safe");

        //Action list
        actions.add("go");
        actions.add("look");
        actions.add("use");
        actions.add("pick");
        actions.add("bag");
        actions.add("quit");

    }
    public String[] readUserInput() {
        System.out.print("> ");
        String commandInput = input.nextLine();
        String[] commandParts = commandInput.split(" ");
        return commandParts;
    }
    public void pickUpItem(Thing I, ItemsList from, ItemsList destination){
        from.remove(I);
        destination.add(I);
    }
    public void openContainer(Thing D, String inName){
        if(inName.equals("suitcase")){
            playerBag.addAll(suitcase.getItems());
        }else if(inName.equals("wallet")){
            playerBag.addAll(wallet.getItems());
        }
        playerBag.remove(D);
        System.out.println("You have collected new items!");
    }
    public Room[][] getMap() {
        return map;
    }

    public void run(){
        boolean running = true; // run game while

        //Welcome menu
        boolean runMenu = true;
        while(runMenu==true) {
            MainMenu mainMenuInput = new MainMenu();
            int menuInput = mainMenuInput.runMenu();
            switch (menuInput) { //Switcher Main menu
                case 1:
                    System.out.println("Loading..."); //Start game
                    System.out.print("");
                    System.out.print("Please enter your name:");
                    System.out.print("> ");
                    this.playerName = this.input.nextLine();
                    System.out.println("\n" + "_________________" + "\n" + playerName.toUpperCase() + "!");
                    Read.read("AA");
                    System.out.println("Press ENTER to continue...");
                    input.nextLine();
                    runMenu=false;
                    break;
                case 2: // load game
                    System.out.println("This option is not available at the moment.");
                    System.out.println("Press ENTER to continue...");
                    input.nextLine();
                    //SaveAndLoad.load(this); //Load game
                    break;
                case 3: // show credits
                    mainMenuInput.Credits();
                    System.out.println("Press ENTER to continue...");
                    input.nextLine();
                    break;
                case 4: // quit game
                    runMenu=false;
                    running = false;
                    break;
                default:
                    System.out.println("Please select a number from the menu.");
                    mainMenuInput.runMenu();
            }
        }

        while (running == true) {
            // Print room information
            System.out.println("\n" + "_________________" + "\n" + map[row][col].getRoomDescription());

            // Read user input
            System.out.println("\n" + "Actions: [go][look at][use][pick up][bag]  [quit]");
            String[] commandParts = readUserInput();
            String command = commandParts[0];
            String target= "";
            if(commandParts.length ==3){
                target = commandParts[2].toLowerCase();
            }
            if(actions.contains(command)){
                switch (command.toLowerCase()){
                    case "bag": // Show which items have been collected
                        System.out.println("You have collected:");
                        System.out.println(playerBag.namesIL());
                        break;
                    case "go": //move player around
                        if (commandParts.length >= 2) { // Kontrollera att man har skrivit något efter go, alltså en riktning
                            if (commandParts[1].equalsIgnoreCase("north") || commandParts[1].equalsIgnoreCase("n")){
                                if (row == 0 || row == 2) {
                                    System.out.println("You can't go north");
                                }else {
                                    row--;
                                    if (row < 0) {
                                        row = 0;
                                    }
                                }
                            }else if (commandParts[1].equalsIgnoreCase("south") || commandParts[1].equalsIgnoreCase("s")){
                                if (row >= 1) {
                                    System.out.println("You can't go south.");
                                } else {
                                    row++;
                                    if (row > map.length) {
                                        row--;
                                    }
                                }
                            }else if (commandParts[1].equalsIgnoreCase("east") || commandParts[1].equalsIgnoreCase("e")){
                                if (col == 2) {
                                    System.out.println("You can't go east");
                                } else {
                                    col++;
                                    if (col >= map.length) {
                                        col--;
                                    }
                                }
                            }else if (commandParts[1].equalsIgnoreCase("west") || commandParts[1].equalsIgnoreCase("w")){
                                if (col == 0) {
                                    System.out.println("You can't go west");
                                } else {
                                    col--;
                                    if (col < 0) {
                                        col = 0;
                                    }
                                }
                            }else if (commandParts[1].equalsIgnoreCase("up")) {
                                if (row == 1 && col == 1) {
                                    col = 1;
                                    row = 2;
                                } else {
                                    System.out.println("You can not go up.");
                                }
                            }else if (commandParts[1].equalsIgnoreCase("down")) {
                                if (row == 2) {
                                    col = 1;
                                    row = 1;
                                } else {
                                    System.out.println("You can not go down.");
                                }
                            }else {
                                System.out.println("You can't go without a direction");
                                System.out.println("E.g. go north");
                            }
                        }
                        break;
                    case "look": //look at room, items or objects
                        if (commandParts.length < 2){
                            System.out.println("You look around the room and you see:");
                            System.out.println(map[this.row][this.col].getItems().describeItems());
                        }else if (commandParts.length < 3) {
                            if (commandParts[1].equalsIgnoreCase("at")) {
                                System.out.println("What do you want to look at?");
                            } else {
                                System.out.println(getRandomAnswer());
                            }
                        }else if(commandParts.length <4 && commandParts[1].equalsIgnoreCase("at")){
                            if(containers.contains(target)){
                                if(playerBag.contains(playerBag.thisItem(target))){
                                    openContainer(playerBag.thisItem(target), target);
                                }else{
                                    System.out.println("You don´t have a " + target + " in your bag.");
                                }
                            }else if(playerBag.contains(playerBag.thisItem(target))){
                                Thing I = playerBag.thisItem(target);
                                System.out.println(I.getDescription());
                            }else if(commandParts[2].equals("window")){
                                if (this.row == 2 && this.col == 2) {
                                    Read.read("BB");
                                }
                            }else if(map[this.row][this.col].getItems().contains(map[this.row][this.col].getItems().thisItem(target))){
                                System.out.println(map[this.row][this.col].getItems().thisItem(target).getDescription());
                            }else {
                                System.out.println("What do you want to look at?");
                            }
                        }else{
                            System.out.println("What do you want to look at?");
                        }
                        break;
                    case "use": //use collected items
                        if (commandParts.length < 2) {
                            System.out.println("What do you want to use?");
                            System.out.println("E.g.: use pen" + "\n" +  "      OR" + "\n" + "      use pen with paper");
                        } else if(commandParts[1].equalsIgnoreCase("safe")){
                            if (this.row==1 && this.col==2){
                                Scanner input = new Scanner(System.in);
                                boolean r = true;
                                while(r==true){
                                    Read.read("CC");
                                    String password = input.nextLine();
                                    String[] passwordParts = password.split("-");
                                    int p = Safe.password(passwordParts);
                                    if (p == 1) {
                                        System.out.println("Press ENTER to continue...");
                                        input.nextLine();
                                        Read.read("FF");
                                        running = false;
                                        r=false;
                                    }else{
                                        System.out.println("Do you want to try again? [Y/N]");
                                        System.out.print("> ");
                                        String answer = input.nextLine();
                                        if ("N".equalsIgnoreCase(answer.toUpperCase())){
                                            r = false;
                                        }
                                    }
                                }
                            }else{
                                System.out.println("There is no safe in here");
                            }
                        } else if(commandParts[1].equalsIgnoreCase("diary")){
                            Read.read("GG");
                        }
                        break;
                    case "pick": // pick up items
                        if (commandParts.length <3) {
                            System.out.println("You need to choose an item to pick up.");
                            System.out.println("E.g.: pick up book");
                        }else if (commandParts[2]!= null) {
                            Thing t = map[this.row][this.col].getItems().thisItem(commandParts[2]);
                            if(objects.contains(commandParts[2])){
                                System.out.println("You can´t carry that around!");
                            }else{
                                if(map[this.row][this.col].getItems().contains(t)) {
                                    pickUpItem(t , map[this.row][this.col].getItems(), player.getItems());
                                    System.out.println("You have picked up a " + t.getName() + ".");
                                }
                            }
                        }else{
                            System.out.println("You can't pick up that!");
                        }
                        break;
                    case "save": // save game
                        System.out.println("That option is not available at the moment.");
                        //SaveAndLoad.save(this.row, this.col);
                        break;
                    case "load": // load game
                        System.out.println("That option is not available at the moment.");
                        //SaveAndLoad.load(this);
                        break;
                    case "quit": // finish game
                        running = false;
                        break;
                }
            }else{
                System.out.println(getRandomAnswer());
            }
        }
    }

    public void quit() {
        System.out.println("Thank you for playing Grand Theft Mansion");
    }
}

