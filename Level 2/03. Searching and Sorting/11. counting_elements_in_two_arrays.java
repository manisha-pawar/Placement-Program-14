import java.util.*;
import java.io.*;

public class Main {

    public static int[] find(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            int count = helper(arr2, arr1[i]);
            ans[i] = count;
        }

        return ans;
    }

    public static int helper(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length - 1;
        int count = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] <= val) {
                count += (mid - lo + 1);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] a = new int[n1];

        for (int i = 0; i < n1; i++) {
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] b = new int[n2];

        for (int i = 0; i < n2; i++) {
            b[i] = scn.nextInt();
        }

        int[] ans = find(a, b);

        for (int val: ans) {
            System.out.print(val + " ");
        }
    }
}