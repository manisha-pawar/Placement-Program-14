import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~

    public static void segmentedSieveAlgo(int a, int b) {
        int n = b - a + 1;

        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);

        ArrayList < Integer > primes = sieve((int) Math.sqrt(b)); //primes in 2 to root(b)

        for (int k: primes) {
            int val = ((int) Math.ceil(a * 1.0 / k) * k);
            int i = val - a;

            if (val == k) {
                i += k;
            }

            for (; i < n; i += k) {
                arr[i] = false;
            }
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] == true && i + a >= 2) {
                System.out.println(i + a);
            }
        }
    }


    public static ArrayList < Integer > sieve(int n) {
        //generate all primes till n
        ArrayList < Integer > ans = new ArrayList < > ();
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
                ans.add(i);
            }
        }

        return ans;
    }




    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
    }
}