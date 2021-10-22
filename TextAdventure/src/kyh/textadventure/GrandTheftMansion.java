package kyh.textadventure;

import java.util.*;


public class GrandTheftMansion {

    Scanner input = new Scanner(System.in);
    //Map size & Coordinates
    int row = 1;
    int col = 1;
    Room[][] map;
    Player player = new Player();
    public ArrayList<Item> itemsList = new ArrayList<>();
    public ArrayList<Item> extraItems = new ArrayList<>();
    public ArrayList<Item> objects = new ArrayList<>();
    public ArrayList<String> sorry = new ArrayList<String>();

    public String getRandomElement(ArrayList<String> sorry){
        Random rand = new Random();
        return sorry.get(rand.nextInt(sorry.size()));
    }

    public void initialization() {

        //Room mindRoom = new Room("Mind room", "This is a room full with memories.");
        Room pinkRoom = new Room("Pink room", "This is a room with pink walls filled with pink furniture.");
        Room studio = new Room("Studio", "This room has all walls covered with books and a desk in the middle.");
        Room kitchen = new Room("Kitchen", "This is a kitchen.");
        Room livingroom = new Room("Living room", "This is a room with a TV.");
        Room entrance = new Room("The entrance", "This is the entrance hall. There is a stair going to the second floor.");
        Room vaultRoom = new Room("Vault room", "There is a big safe in the middle of the room.");
        Room room1 = new Room("Room 1", "This is a room with just a single bed.");
        Room mainRoom = new Room("Main room", "This is the main room with double bed and a walking closet.");
        Room room2 = new Room("Room 2", "This is an empty room");

        map = new Room[][]{
                {pinkRoom, studio, kitchen},
                {livingroom, entrance, vaultRoom},
                {room1, mainRoom, room2}
        };

        Item grog = new Item("Bottle", "Bottle  of Grog: a dilution of rum with water, with lime and sugar added.");
        pinkRoom.setItem(grog);
        itemsList.add(grog);
        Item note = new Item("Note", "A small piece of paper with some annotations.");
        entrance.setItem(note);
        itemsList.add(note);
        Item hairpin = new Item("Hairpin", "A hairpin made of metal.");
        room1.setItem(hairpin);
        itemsList.add(hairpin);
        Item diary = new Item("Diary", "A small book with person's experiences, thoughts, and feelings.");
        studio.setItem(diary);
        itemsList.add(diary);
        Item knife = new Item("Knife", "A blunt knife used for cutting or spreading butter.");
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
        Item safe = new Item("Safe", "A strong fireproof cabinet with a complex lock, used for the storage of valuables.\n Safe instructions: YYYY-MM-DD-****");
        vaultRoom.setObject(safe);
        objects.add(safe);
        Item fireplace = new Item("Fireplace", "A place to make a fire. Looks like there is something in the back, but I can't see well through the fire.");
        livingroom.setObject(fireplace);
        objects.add(fireplace);
        Item door = new Item("Door", "This door seams to be locked. I wonder what kind of room is on the other side?");
        pinkRoom.setObject(door);
        objects.add(door);


        Container suitcase = new Container("Suitcase", "A case used for carrying clothes and other personal possessions.");
        Item wallet = new Item("Wallet", "A pocket-sized, flat, folding holder for money and plastic cards.");
        Item pen = new Item("Pen", "An instrument for writing.");
        Item picture = new Item("Picture frame", "Has a picture of a dog wearing a suit and a hat, and a white rabbit. They look kinda familiar...");
        suitcase.addItemsToContainer(wallet);
        suitcase.addItemsToContainer(pen);
        suitcase.addItemsToContainer(picture);
        mainRoom.setItem(suitcase);
        itemsList.add(suitcase);

        //Sorry not sorry
        sorry.add("Sorry, I don't understand what are you saying.");
        sorry.add("No hablo español.");
        sorry.add("What did you just say?");
        sorry.add("I can't process that order.");

    }



    public String[] readUserInput() {
        System.out.print("> ");
        String commandInput = input.nextLine();
        String[] commandParts = commandInput.split(" ");
        return commandParts;
    }

    public void run() {
        //Welcome menu
        ArrayList playerBag = new ArrayList();
        MainMenu mainMenuInput = new MainMenu();
        int menuInput = mainMenuInput.runMenu();

        boolean running = true; // run game while

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
                System.out.println(objects); // HallOfFame.ranking();
                mainMenuInput.runMenu();
                break;
            case 4:
                running = false;
                break;
        }

        while (running == true) {
            // Skriv ut i vilket rum vi är i
            System.out.println(map[row][col].toString());

            // Läs in kommando från användaren
            System.out.println("\n" + "Actions: [go][look att][use][pick up][Items]  [save][quit]");
            String[] commandParts = readUserInput();
            String command = commandParts[0];

            // Show which items have been collected
            if (command.equalsIgnoreCase("items")) {
                player.printBag();
            }

            // 4. Kollar vilket "huvudkommando" som angivits
            //    Dessa är:
            //      X go        X pick up
            //      - look at   - use
            //
            if (command.equalsIgnoreCase("go")) {
                if (commandParts.length >= 2) { // Kontrollera att man har skrivit något efter go, alltså en riktning
                    if (commandParts[1].equalsIgnoreCase("north")) {
                        if (row == 0 || row == 2) {
                            System.out.println("You can't go north");
                        } else {
                            row--;
                            if (row < 0) {
                                row = 0;
                            }
                        }
                    } else if (commandParts[1].equalsIgnoreCase("south")) {
                        if (row >= 1) {
                            System.out.println("You can't go south.");
                        } else {
                            row++;
                            if (row > map.length) {
                                row--;
                            }
                        }
                    } else if (commandParts[1].equalsIgnoreCase("east")) {
                        if (col == 2) {
                            System.out.println("You can't go east");
                        } else {
                            col++;
                            if (col >= map.length) {
                                col--;
                            }
                        }
                    } else if (commandParts[1].equalsIgnoreCase("west")) {
                        if (col == 0) {
                            System.out.println("You can't go west");
                        } else {
                            col--;
                            if (col < 0) {
                                col = 0;
                            }
                        }
                    } else if (commandParts[1].equalsIgnoreCase("up")) {
                        if (row == 1 && col == 1) {
                            col = 1;
                            row = 2;
                        } else {
                            System.out.println("You can not go up.");
                        }
                    } else if (commandParts[1].equalsIgnoreCase("down")) {
                        if (row == 2) {
                            col = 1;
                            row = 1;
                        } else {
                            System.out.println("You can not go down.");
                        }
                    } else {
                        System.out.println("You can't go without a direction");
                        System.out.println("E.g. go north");
                    }
                }
            }

            if (command.equalsIgnoreCase("look")) {
                if (commandParts.length < 2) {
                    System.out.println(map[this.row][this.col].getItDescript());
                    System.out.println("");
                }
            }


            /*if (command.equalsIgnoreCase("use")) {
                String useItem = commandParts[1];
                if () {
                    //grog, bobby pin, pen, picture frame, bobby pen (bobby pin + pen)
                }*/

            if (command.equalsIgnoreCase("pick")) {
                if (commandParts.length <3) {
                    System.out.println("You need to choose an item to pick up.");
                    System.out.println("E.g. pick up book");
                }else if (commandParts[2]!= null) {
                    for (Item OLoop : objects) {
                        if (OLoop.type.equalsIgnoreCase(commandParts[2])) {
                            System.out.println("I can´t carry that around!");
                        }
                    }
                    for (Item ILoop : itemsList) {
                            if (ILoop.type.equalsIgnoreCase(commandParts[2])) {
                                map[this.row][this.col].removeItem();
                                System.out.println("You have picked up a " + ILoop.type + ".");
                                player.addItem(ILoop.type, ILoop.description);
                                int i = itemsList.indexOf(ILoop);
                                itemsList.remove(i);
                                break;
                            }
                    }
                }else{
                    System.out.println("You can't pick up that!");
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
                //default:
                   // System.out.println(getRandomElement(sorry));
            }
        }
    }

    public void quit() {
        System.out.println("Thank you for playing Grand Theft Mansion");
    }
}

