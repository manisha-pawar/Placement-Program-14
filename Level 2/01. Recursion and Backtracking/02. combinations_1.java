import java.io.*;
import java.util.*;

public class Main {


    //ssf - selection so far
    public static void combinations(int cb, int n, int ssf, int r, String asf) {
        if (cb > n) {
            if (ssf == r) {
                System.out.println(asf);
            }
            return;
        }

        //box - yes choice
        combinations(cb + 1, n, ssf + 1, r, asf + "i");

        //box - no choice
        combinations(cb + 1, n, ssf, r, asf + "-");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
    }

}