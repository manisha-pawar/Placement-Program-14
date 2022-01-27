import java.util.*;
import java.io.*;

public class Main {

    public static int count(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        int prev = Integer.MIN_VALUE;
        int next = Integer.MAX_VALUE;
        int count = 0;


        while (i <= j) {
            if (Math.abs(arr[i]) == Math.abs(arr[j])) {
                if (arr[i] != prev && arr[j] != next) {
                    count++;
                }
                prev = arr[i];
                next = arr[j];
                i++;
                j--;
            } else if (Math.abs(arr[i]) < Math.abs(arr[j])) {
                if (arr[j] != next) {
                    count++;
                }
                next = arr[j];
                j--;
            } else {
                if (arr[i] != prev) {
                    count++;
                }
                prev = arr[i];
                i++;
            }
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

        System.out.println(count(arr));
    }
}