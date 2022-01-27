import java.util.*;
import java.io.*;

public class Main {

    public static int findSingleElement(int[] arr) {
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        int n = arr.length;

        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int m = (lo + hi) / 2;

            //if arr[m] is single element
            if (arr[m] != arr[m - 1] && arr[m] != arr[m + 1]) {
                return arr[m];
            } else if (arr[m] == arr[m - 1]) {
                //lo to mid -> left part
                //mid+1 to hi -> right part

                int lc = m - lo + 1;

                if (lc % 2 == 0) {
                    lo = m + 1;
                } else {
                    hi = m - 2;
                }
            } else if (arr[m] == arr[m + 1]) {
                //lo to mid-1 -> left part
                //mid to hi -> right part

                int rc = hi - m + 1;

                if (rc % 2 == 0) {
                    hi = m - 1;
                } else {
                    lo = m + 2;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findSingleElement(arr);
        System.out.println(ans);
    }
}