public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */

    // T : O(n+k), k -> number of queries, n -> length of the array
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        //impact of queries on the array
        for (int i = 0; i < updates.length; i++) {
            int si = updates[i][0];
            int ei = updates[i][1];
            int inc = updates[i][2];

            arr[si] += inc;

            if (ei + 1 < length) {
                arr[ei + 1] -= inc;
            }
        }


        //prefix sum 
        int ps = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ps += arr[i];
            arr[i] = ps;
        }

        return arr;
    }
}