//https://leetcode.com/problems/partition-array-into-disjoint-intervals/


//1. Time : O(n), Space : O(n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int[]lmax = new int[nums.length];
        int[]rmin = new int[nums.length + 1];
        
        lmax[0] = nums[0];
        for(int i=1; i < nums.length;i++) {
            lmax[i] = Math.max(lmax[i-1],nums[i]);
        }
        
        rmin[nums.length] = Integer.MAX_VALUE;
        for(int i=nums.length-1;i >= 0;i--) {
            rmin[i] = Math.min(rmin[i+1],nums[i]);
        }
        
        
        for(int i=0; i < nums.length;i++) {
            if(lmax[i] <= rmin[i+1]) {
                return i+1;
            }
        }
        
        return -1;
    }
}


//2. Time : O(n), Space : O(1)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int lmax = nums[0]; //left max
        int pmax = nums[0]; //maximum of potential ans's left hand side 
        int pa = 0;
        
        for(int i=0; i < nums.length;i++) {
            if(nums[i] >= lmax) {
                lmax = nums[i];
            }
            else if(nums[i] < pmax) {
                pa = i;
                pmax = lmax;
            }
        }
        
        return pa + 1;
        
    }
}