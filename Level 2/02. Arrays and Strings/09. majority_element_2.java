//https://leetcode.com/problems/majority-element-ii/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int v1 = nums[0];
        int c1 = 1;
        
        int v2 = 0;
        int c2 = 0;
        
        
        for(int i=1; i < nums.length;i++) {
            if(nums[i] == v1) {
                c1++;
            }
            else if(nums[i] == v2) {
                c2++;
            }
            else {
                if(c1 == 0) {
                    v1 = nums[i];
                    c1 = 1;
                }
                else if(c2 == 0) {
                    v2 = nums[i];
                    c2 = 1;
                }
                else {
                   c1--;
                   c2--;
                }
            }
        }
        
        
        int f1 = 0,f2 = 0;
        
        for(int i=0; i < nums.length;i++) {
            if(nums[i] == v1) {
                f1++;
            }
            else if(nums[i] == v2) {
                f2++;
            }
        }
        
        List<Integer>ans = new ArrayList<>();
        
        if(f1 > nums.length / 3) {
            ans.add(v1);
        }
        
        if(f2 > nums.length / 3) {
            ans.add(v2);
        }
        

        
        return ans;
        
        
    }
}