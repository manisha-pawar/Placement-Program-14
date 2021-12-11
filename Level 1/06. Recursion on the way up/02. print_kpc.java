import java.io.*;
import java.util.*;

public class Main {

    static String[] code = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printKPC(str, "");
    }

    public static void printKPC(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        String mycode = code[ch - '0'];

        for (int i = 0; i < mycode.length(); i++) {
            char mch = mycode.charAt(i);

            printKPC(ros, asf + mch);
        }
    }

}