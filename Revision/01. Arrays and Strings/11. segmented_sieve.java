import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~

    public static ArrayList < Integer > sieve(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int temp = 2; temp * temp <= n; temp++) {
            if (arr[temp] == true) {
                for (int k = temp * 2; k <= n; k += temp) {
                    arr[k] = false;
                }
            }
        }

        ArrayList < Integer > list = new ArrayList < > ();
        for (int i = 2; i <= n; i++) {
            if (arr[i] == true) {
                list.add(i);
            }
        }

        return list;
    }

    public static void segmentedSieveAlgo(int a, int b) {
        int n = b - a + 1;

        ArrayList < Integer > primes = sieve((int) Math.sqrt(b));
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);

        for (int temp: primes) {
            int t = (int) Math.ceil(a * 1.0 / temp);

            if(t == 0 || t == 1) {
                t = 2;
            }

            int smt = t * temp; //smallest multiple of temp in a to b

            int idx = smt - a;

            for (int k = idx; k < arr.length; k += temp) {
                arr[k] = false;
            }
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true && (a + i) >= 2) {
                System.out.print((a + i) + " ");
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
    }
}