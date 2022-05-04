class Solution {
    public int maximumProduct(int[] nums) {
        int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tmax = Integer.MIN_VALUE;
        int fmin = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        for(int i=0; i < nums.length;i++) {
            //updation of max
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
            
            //updation of min
            if(nums[i] < fmin) {
                smin = fmin;
                fmin = nums[i];
            }
            else if(nums[i] < smin) {
                smin = nums[i];
            }
        }
        
        
        int c1 = fmax * smax * tmax;
        int c2 = fmin * smin * fmax;
        
        return Math.max(c1,c2);
    }
}