//https://leetcode.com/problems/first-missing-positive/submissions/

class Solution {
    public int firstMissingPositive(int[] nums) {
        //segregate +ve and -ve
        int pe = segregate(nums);
        
        for(int i=0; i <= pe;i++) {
            int idx = Math.abs(nums[i]) - 1;
            
            if(idx <= pe && nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        
        for(int i=0; i<=pe;i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        
        return pe + 2;
    }
    
    public static int segregate(int[]nums) {
        int i = 0;
        int j = 0;
        
        //0 to i-1 -> > 0
        //i to j-1 -> <= 0
        //j to n-1 -> unknowns
        
        while(j < nums.length) {
            if(nums[j] <= 0) {
                j++;
            }
            else {
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j++;
            }
        }
        
        return i-1;
    }
}