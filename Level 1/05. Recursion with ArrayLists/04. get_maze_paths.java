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

        if (sr > dr || sc > dc) {
            ArrayList < String > bans = new ArrayList < > ();
            return bans;
        }

        ArrayList < String > hntod = getMazePaths(sr, sc + 1, dr, dc); //horizontal nbr to dest
        ArrayList < String > vntod = getMazePaths(sr + 1, sc, dr, dc); //vertical nbr to dest

        ArrayList < String > stod = new ArrayList < > ();

        //src to dest -> 'h' + horizontal nbr to dest
        for (int i = 0; i < hntod.size(); i++) {
            stod.add('h' + hntod.get(i));
        }

        //src to dest -> 'v' + vertical nbr to dest
        for (int i = 0; i < vntod.size(); i++) {
            stod.add('v' + vntod.get(i));
        }

        return stod;

    }

}