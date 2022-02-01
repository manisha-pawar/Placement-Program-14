 class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        //if array is not rotated at all, it is sorted
        if(nums[lo] <= nums[hi]) {
            return nums[lo];
        }
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            //is mid part1's last element
            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            //is mid part2's first element
            else if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            //discard sorted half
            if(nums[lo] <= nums[mid]) {
                //lo to mid is sorted
                lo = mid+1;
            }
            else {
                //mid to hi is sorted
                hi = mid-1;
            }
        }
        
        return -1;
    }
}