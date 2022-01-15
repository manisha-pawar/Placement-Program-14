import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int k = 2; k * k <= n; k++) {
            if (arr[k] == true) {
                for (int i = 2 * k; i <= n; i += k) {
                    arr[i] = false;
                }
            }
        }


        for (int i = 2; i <= n; i++) {
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