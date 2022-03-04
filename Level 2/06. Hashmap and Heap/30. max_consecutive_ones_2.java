//https://www.lintcode.com/problem/883/

//you can flip atmost 1 zero
public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = -1;
        int j = -1;
        int mlen = 0;
        int cz = 0;

        while (i < nums.length - 1) {
            //aquire
            while (i < nums.length - 1) {
                i++;
                if (nums[i] == 0) {
                    cz++;
                }
                if (cz <= 1) {
                    int temp = i - j;
                    mlen = Math.max(temp, mlen);
                } 
                else {
                    //more then one 0
                    break;
                }
            }

            //release
            while (j < i) {
                j++;
                if (nums[j] == 0) {
                    cz--;
                    break;
                }
            }
        }
        return mlen;

    }
}