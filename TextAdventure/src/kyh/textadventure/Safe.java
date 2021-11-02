package kyh.textadventure;

import java.util.Scanner;

public class Safe {

    public static int password() {
        Scanner input = new Scanner(System.in);
        String Y = "19871105";
        String S = "2408";
        Read.read("CC");
        System.out.print("> ");
        String passwordTest = input.nextLine();
        String[] passwordSplit = passwordTest.split("-");
        if (Y.equals(passwordSplit[0]) && S.equals(passwordSplit[1])) {
            System.out.println("CONGRATULATIONS! \nYOU HAVE OPENED THE SAFE");
            return 1;
        } else {
            System.out.println("Wrong password");
            return 0;
        }
    }
}
