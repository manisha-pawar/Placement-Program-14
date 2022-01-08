//https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
       int val = nums[0];
       int count = 1;
        
       for(int i = 1; i < nums.length;i++) {
           if(nums[i] == val) {
               count++;

           }
           else {
               count--;
           }
           
           if(count == 0) {
               val = nums[i];
               count = 1;
           }
       }
        
       //val contains potential majority element
       int freq = 0;
        
        for(int i=0; i < nums.length;i++) {
            if(nums[i] == val) {
                freq++;
            }
        }
        
        if(freq > nums.length/2) {
            return val;
        }
        else {
            System.out.println("No majority element");
            return -1;
        }
    }
}