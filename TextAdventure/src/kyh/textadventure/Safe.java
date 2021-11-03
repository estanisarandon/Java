package kyh.textadventure;

import java.util.Scanner;

public class Safe {

    public static int password(String[] input) {
        String Y = "19871105";
        String S = "2408";
        if (Y.equals(input[0]) && S.equals(input[1])) {
            System.out.println("CONGRATULATIONS! \nYOU HAVE OPENED THE SAFE\n");
            return 1;
        } else {
            System.out.println("Wrong password");
            return 0;
        }
    }
}
