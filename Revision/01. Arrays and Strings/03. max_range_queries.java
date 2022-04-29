/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }


    public static void main(String[] args) throws java.lang.Exception {
        FastReader scn = new FastReader();

        int T = scn.nextInt();

        while (T-- > 0) {
            int n = scn.nextInt(); //number of queries
            int k = scn.nextInt();
            int[] arr = new int[100000];
            int[][] updations = new int[n][2];
            int idx = 0;

            while (idx < n) {
                int si = scn.nextInt();
                int ei = scn.nextInt();

                updations[idx][0] = si;
                updations[idx][1] = ei;

                arr[si] += 1;

                if (ei + 1 < arr.length)
                    arr[ei + 1] -= 1;

                idx++;
            }


            int ps = arr[0];
            for (int i = 1; i < arr.length; i++) {
                ps += arr[i];
                arr[i] = ps;
            }


            int[] ck = new int[arr.length]; //count of k's till i
            int[] ckp1 = new int[arr.length]; //count of k+1 till int

            ck[0] = arr[0] == k ? 1 : 0;
            ckp1[0] = arr[0] == k + 1 ? 1 : 0;
            int total = ck[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == k) {
                    ck[i] = ck[i - 1] + 1;
                    total++;
                } 
                else {
                    ck[i] = ck[i - 1];
                }

                if (arr[i] == k + 1) {
                    ckp1[i] = ckp1[i - 1] + 1;
                } 
                else {
                    ckp1[i] = ckp1[i - 1];
                }
            }


            int ans = 0;

            for (int i = 0; i < updations.length; i++) {
                int si = updations[i][0];
                int ei = updations[i][1];

                int v1 = ck[ei] - (si == 0 ? 0 : ck[si - 1]);
                int v2 = ckp1[ei] - (si == 0 ? 0 : ckp1[si - 1]);

                int count = total - v1 + v2;

                if (count > ans) {
                    ans = count;
                }
            }

            System.out.println(ans);
        }
    }
}