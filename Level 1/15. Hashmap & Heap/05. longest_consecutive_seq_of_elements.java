import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        longestConsecutiveSeq(arr);
    }

    public static void longestConsecutiveSeq(int[] arr) {
        //1. find the seq start points
        HashMap < Integer, Boolean > map = new HashMap < > ();

        //a. assume all elements as seq start
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        //b. discard elements which can't be a seq start
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - 1) == true) {
                map.put(arr[i], false);
            }
        }


        //2. find the longest consecutive seq
        int olen = 0;
        int st = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == true) {
                int len = 0;

                while (map.containsKey(arr[i] + len) == true) {
                    len++;
                }

                if (len > olen) {
                    olen = len;
                    st = arr[i];
                }

            }
        }


        for (int k = st; k < st + olen; k++) {
            System.out.println(k);
        }
    }

}