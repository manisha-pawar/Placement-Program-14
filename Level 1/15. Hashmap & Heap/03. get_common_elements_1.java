import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
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

        gce1(arr1, arr2);

    }

    public static void gce1(int[] a1, int[] a2) {
        HashSet < Integer > hs = new HashSet < > ();

        //build hs using a1
        for (int i = 0; i < a1.length; i++) {
            hs.add(a1[i]);
        }

        //print common elements in order a2
        for (int i = 0; i < a2.length; i++) {
            if (hs.contains(a2[i]) == true) {
                System.out.println(a2[i]);
                hs.remove(a2[i]);
            }
        }
    }
}