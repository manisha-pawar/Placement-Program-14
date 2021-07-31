import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList < String > paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > bans = new ArrayList < > ();
            bans.add("");
            return bans;
        }

        ArrayList < String > stod = new ArrayList < > ();

        //horizontal moves
        for (int k = 1; sc + k <= dc; k++) {
            ArrayList < String > hntod = getMazePaths(sr, sc + k, dr, dc);

            for (int i = 0; i < hntod.size(); i++) {
                stod.add("h" + k + hntod.get(i));
            }
        }

        //vertical moves
        for (int k = 1; sr + k <= dr; k++) {
            ArrayList < String > vntod = getMazePaths(sr + k, sc, dr, dc);

            for (int i = 0; i < vntod.size(); i++) {
                stod.add("v" + k + vntod.get(i));
            }
        }


        //diagonal moves
        for (int k = 1; sr + k <= dr && sc + k <= dc; k++) {
            ArrayList < String > dntod = getMazePaths(sr + k, sc + k, dr, dc);

            for (int i = 0; i < dntod.size(); i++) {
                stod.add("d" + k + dntod.get(i));
            }
        }


        return stod;

    }


}