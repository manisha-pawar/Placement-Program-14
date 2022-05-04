class Solution {
    //Time : O(n), Space : O(1)
    public int firstMissingPositive(int[] nums) {
       //put Integer.MAX_VALUE in place of negative numbers or 0
        for(int i=0; i < nums.length;i++) {
            if(nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        
        //marking
        for(int i=0; i < nums.length;i++) {
            int val = Math.abs(nums[i]);
            
            if(val-1 < nums.length && nums[val-1] > 0) {
                nums[val-1] = -nums[val-1];
            }
        }
        
        
        //find your ans - the first unmarked spot
        for(int i=0; i < nums.length;i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        
        return nums.length+1;
        
    }
}