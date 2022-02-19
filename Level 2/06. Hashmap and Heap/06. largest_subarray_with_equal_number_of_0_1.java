//1. using gap(c0-c1) as key
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>(); //gap(c0 - c1)  vs first idx
        int c0 = 0;
        int c1 = 0;
        int olen = 0;
        
        map.put(c0-c1,-1);
        
        for(int i=0; i < nums.length;i++) {
            if(nums[i] == 0) {
                c0++;
            }
            else {
                c1++;
            }
            
            int gap = c0-c1;
            
            if(map.containsKey(gap) == true) {
                int len = i - map.get(gap);
                olen = Math.max(len,olen);
            }
            else {
                map.put(gap,i);
            }
        }
        
        return olen;
    }
}



//2. using largest subarray with sum 0
class Solution {
    public int findMaxLength(int[] nums) {
        //replace 0 with -1
        
        for(int i=0; i < nums.length;i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        //apply largest subarray having sum = 0
        HashMap<Integer,Integer>map = new HashMap<>(); //ps vs fi
        map.put(0,-1);
        int ps = 0;
        int olen = 0;
        
        for(int i=0; i < nums.length;i++) {
            ps += nums[i];
            
            if(map.containsKey(ps) == true) {
                int len = i - map.get(ps);
                olen =  Math.max(olen,len);
            }
            else {
                map.put(ps,i);
            }
        }
        
        return olen;
    }
}
