class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        
        for(int val : nums) {
            max = Math.max(max,val);
        }
        
        if(threshold == nums.length) {
            return max;
        }
        
        int lo = 1, hi = max;
        int ans = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isPossible(nums,mid,threshold) == true) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    
    public static boolean isPossible(int[]nums,int div,int threshold) {
        int res = 0;
        
        for(int i=0; i < nums.length;i++) {
            res += Math.ceil(nums[i]*1.0 / div);
        }
        
        return res <= threshold;
    }
    
    
}