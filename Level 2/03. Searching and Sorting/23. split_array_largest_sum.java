class Solution {
    public int splitArray(int[] nums, int m) {
        int max = nums[0];
        int sum = 0;
        
        for(int val : nums) {
            max = Math.max(max,val);
            sum += val;
        }
        
        int lo = max;
        int hi = sum;
        int ans = 0;
        
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isPossible(nums,mid,m) == true) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return ans;
        
    }
    
    
    public static boolean isPossible(int[]arr,int mid,int m) {
        int sa = 1;
        int sum = 0;
        
        for(int i=0; i < arr.length;i++) {
            sum += arr[i];
            
            if(sum > mid) {
                sa++;
                sum = arr[i];
            }
        }
        
        return sa <= m;
    }
}