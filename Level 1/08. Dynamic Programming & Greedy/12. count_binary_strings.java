import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(cbs(n));
    }


    //using tabulation
    public static int cbs(int n) {
        int ocz = 1; //old count zero
        int oco = 1; //old count one

        for (int i = 2; i <= n; i++) {
            int ncz = oco; //new count zero
            int nco = oco + ocz; //new count one

            oco = nco;
            ocz = ncz;
        }

        return ocz + oco;
    }


    //recursion -> type 'a', type 'b' problem
    public static int cbs(int n, char type) {
        if (n == 1) {
            return 1;
        }

        int ans = 0;

        if (type == 'a') {
            //n length binary string which ends at 0 and has no consecutive 0's
            ans = cbs(n - 1, 'b');
        } else {
            //n length binary string which ends at 1 and has no consecutive 0's
            ans = cbs(n - 1, 'a') + cbs(n - 1, 'b');
        }

        return ans;

    }


    //recursion -> return both ans in array
    public static int[] cbs2(int n) {
        if (n == 1) {
            int[] ba = {
                1,
                1
            };
            return ba;
        }

        int[] sa = cbs2(n - 1);

        int[] ma = {
            sa[1],
            sa[0] + sa[1]
        };

        return ma;

    }


}