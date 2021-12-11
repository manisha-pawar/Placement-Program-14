import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        System.out.println(lastIndex(arr, 0, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int lisa = lastIndex(arr, idx + 1, x); //last index in smaller array

        if (lisa != -1) {
            return lisa;
        } else {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        }
    }

}