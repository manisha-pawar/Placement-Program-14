import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        gce2(arr1, arr2);
    }


    public static void gce2(int[] a1, int[] a2) {
        HashMap < Integer, Integer > map = new HashMap < > ();

        //populate map using a1
        for (int i = 0; i < a1.length; i++) {
            if (map.containsKey(a1[i]) == false) {
                map.put(a1[i], 1);
            } else {
                int nf = map.get(a1[i]) + 1;
                map.put(a1[i], nf);
            }
        }


        //print common elements in order a2
        for (int i = 0; i < a2.length; i++) {
            if (map.containsKey(a2[i]) == true && map.get(a2[i]) > 0) {
                System.out.println(a2[i]);
                int nf = map.get(a2[i]) - 1;
                map.put(a2[i], nf);
            }
        }

    }

}