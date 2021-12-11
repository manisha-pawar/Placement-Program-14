import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        ArrayList < String > ss = gss(str);
        System.out.println(ss);
    }

    public static ArrayList < String > gss(String str) {
        if (str.length() == 0) {
            ArrayList < String > bans = new ArrayList < > ();
            bans.add("");
            return bans;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList < String > rans = gss(ros); //faith
        ArrayList < String > myans = new ArrayList < > ();


        //ch -> no choice
        for (int i = 0; i < rans.size(); i++) {
            myans.add(rans.get(i));
        }

        //ch -> yes choice
        for (int i = 0; i < rans.size(); i++) {
            myans.add(ch + rans.get(i));
        }

        return myans;
    }

}