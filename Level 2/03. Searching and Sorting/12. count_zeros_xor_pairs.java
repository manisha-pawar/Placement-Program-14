import java.util.*;
import java.io.*;

public class Main {
    public static int countPairs(int[] arr) {
        HashMap < Integer, Integer > map = new HashMap < > ();

        for (int ele: arr) {
            if (map.containsKey(ele) == false) {
                map.put(ele, 1);
            } else {
                int nf = map.get(ele) + 1;
                map.put(ele, nf);
            }
        }

        int count = 0;

        for (int key: map.keySet()) {
            int c = map.get(key);
            count += (c * (c - 1) / 2);
        }

        return count;
    }

    public static void main(String[] args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(countPairs(arr));
    }
}