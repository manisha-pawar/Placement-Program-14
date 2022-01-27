class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        int[]res = new int[nums.length];
        int n = nums.length;
        
        //odd indexes
        int i = 1;
        int k = n-1;
        
        while(i < nums.length) {
            res[i] = nums[k];
            i += 2;
            k--;
        }
        
        //even indexes
        i = 0;
        
        while(i < nums.length) {
            res[i] = nums[k];
            i += 2;
            k--;
        }
        
        
        //copy res to nums
        for(int j=0; j < nums.length;j++) {
            nums[j] = res[j];
        }
        
    }
}