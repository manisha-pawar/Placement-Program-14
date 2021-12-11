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

        ArrayList < String > kpc = getKPC(str);
        int val = Integer.parseInt("51");
        System.out.println(kpc);
    }

    public static ArrayList < String > getKPC(String str) {
        if (str.length() == 0) {
            ArrayList < String > bans = new ArrayList < > (); //base ans
            bans.add("");
            return bans;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1); //rest of the string

        ArrayList < String > rans = getKPC(ros); //recursion ans
        ArrayList < String > myans = new ArrayList < > ();

        String mycode = code[ch - '0'];

        for (int i = 0; i < mycode.length(); i++) {
            char mch = mycode.charAt(i);

            for (int j = 0; j < rans.size(); j++) {
                myans.add(mch + rans.get(j));
            }
        }

        return myans;

    }

}