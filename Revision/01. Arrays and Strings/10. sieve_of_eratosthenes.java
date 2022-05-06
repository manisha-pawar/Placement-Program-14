import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int temp = 2; temp * temp <= n; temp++) {
            if (arr[temp] == true) {
                //run temp's table
                for (int k = temp * 2; k <= n; k += temp) {
                    arr[k] = false;
                }
            }
        }


        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == true) {
                System.out.print(i + " ");
            }
        }
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}