//https://www.codechef.com/problems/MAXREMOV


public class Main {
    public static void main(String[] args) {
        int len = 8;
        
        int[][]queries = {{1,5},{2,7},{0,3},{6,7}};
        int k = 2;

        int[] arr = range_addition(len, queries);

        int[] kc = new int[len]; //kc[i] -> count of k's till i
        int[] kp1c = new int[len]; //kp1c[i] -> count of (k+1)s till i

        kc[0] = arr[0] == k ? 1 : 0;
        kp1c[0] = arr[0] == k + 1 ? 1 : 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == k) {
                kc[i] = kc[i - 1] + 1;
            } else {
                kc[i] = kc[i - 1];
            }

            if (arr[i] == k + 1) {
                kp1c[i] = kp1c[i - 1] + 1;
            } else {
                kp1c[i] = kp1c[i - 1];
            }
        }

        int[] ans = new int[2];
        int total = kc[len - 1];
        int maxK = 0;

        for (int q = 0; q < queries.length; q++) {
            int si = queries[q][0];
            int ei = queries[q][1];

            int siToeiKC = kc[ei] - (si == 0 ? 0 : kc[si - 1]);
            int siToeiKP1C = kp1c[ei] - (si == 0 ? 0 : kp1c[si - 1]);

            int remK = total - siToeiKC + siToeiKP1C;

            if (remK > maxK) {
                maxK = remK;
                ans[0] = si;
                ans[1] = ei;
            }
        }

        System.out.println("Query : " + ans[0] + " " + ans[1]);
        System.out.println("Maximised K : " + maxK);
    }

    public static int[] range_addition(int len, int[][] updates) {
        int[] arr = new int[len];

        for (int i = 0; i < updates.length; i++) {
            int si = updates[i][0];
            int ei = updates[i][1];

            arr[si] += 1;

            if (ei + 1 < arr.length) {
                arr[ei + 1] -= 1;
            }
        }

        int[] psa = new int[arr.length];
        psa[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            psa[i] = psa[i - 1] + arr[i];
        }

        return psa;
    }
}