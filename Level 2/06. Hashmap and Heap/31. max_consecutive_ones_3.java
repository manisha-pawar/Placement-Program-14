//https://leetcode.com/problems/max-consecutive-ones-iii/

//you can flip atmost k zeros
class Solution {
    public int longestOnes(int[] nums, int k) {
        int cz = 0; //count of zeros
        int olen = 0;

        int i = -1;
        int j = -1;

        int n = nums.length;

        while(i < n-1) {
            //aquire
            while(i < n-1) {
                i++;

                if(nums[i] == 0) {
                    cz++;
                }

                if(cz <= k) {
                    //update ans
                    int len = i - j;
                    olen = Math.max(olen,len);
                }
                else {
                    break;
                }
            }

            //release
            while(j < i) {
                j++;

                if(nums[j] == 0) {
                    cz--;
                    break;
                }
            }
        }

        return olen;
    }
}