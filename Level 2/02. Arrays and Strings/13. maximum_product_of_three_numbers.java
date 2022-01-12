//https://leetcode.com/problems/maximum-product-of-three-numbers/

class Solution {
    public int maximumProduct(int[] nums) {
        int fmin = Integer.MAX_VALUE; //first min
        int smin = Integer.MAX_VALUE; //second min
        int fmax = Integer.MIN_VALUE; //first max
        int smax = Integer.MIN_VALUE; //second max
        int tmax = Integer.MIN_VALUE; //third max
        
        for(int i=0; i < nums.length;i++) {
            //maintain minimums
            if(nums[i] < fmin) {
                smin = fmin;
                fmin = nums[i];
            }
            else if(nums[i] < smin) {
                smin = nums[i];
            }
            
            //maintain maximums
            if(nums[i] > fmax) {
                tmax = smax;
                smax = fmax;
                fmax = nums[i];
            }
            else if(nums[i] > smax) {
                tmax = smax;
                smax = nums[i];
            }
            else if(nums[i] > tmax) {
                tmax = nums[i];
            }
        }
        
        
        int f1 = fmin * smin * fmax;
        int f2 = fmax * smax * tmax;
        
        return Math.max(f1,f2);
    }
}