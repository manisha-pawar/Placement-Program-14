import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList < String > paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList < String > getStairPaths(int n) {
        if (n == 0) {
            ArrayList < String > bans = new ArrayList < String > ();
            bans.add("");
            return bans;
        }

        if (n < 0) {
            ArrayList < String > bans = new ArrayList < String > ();
            return bans;
        }

        ArrayList < String > nm1to0 = getStairPaths(n - 1); //n-1 to 0
        ArrayList < String > nm2to0 = getStairPaths(n - 2); //n-2 to 0
        ArrayList < String > nm3to0 = getStairPaths(n - 3); //n-3 to 0

        ArrayList < String > nto0 = new ArrayList < > ();

        //n to 0 ->  '1' + n-1 to 0
        for (int i = 0; i < nm1to0.size(); i++) {
            nto0.add('1' + nm1to0.get(i));
        }

        //n to 0 -> '2' + n-2 to 0
        for (int i = 0; i < nm2to0.size(); i++) {
            nto0.add('2' + nm2to0.get(i));
        }

        //n to 0 -> '3' + n-3 to 0
        for (int i = 0; i < nm3to0.size(); i++) {
            nto0.add('3' + nm3to0.get(i));
        }

        return nto0;

    }

}