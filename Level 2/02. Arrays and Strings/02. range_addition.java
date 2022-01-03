//https://www.lintcode.com/problem/903/

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for (int k = 0; k < updates.length; k++) {
            int si = updates[k][0];
            int ei = updates[k][1];
            int inc = updates[k][2];

            arr[si] += inc;

            if (ei + 1 < arr.length) {
                arr[ei + 1] += -inc;
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