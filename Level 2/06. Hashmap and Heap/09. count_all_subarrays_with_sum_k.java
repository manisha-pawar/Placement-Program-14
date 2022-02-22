class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>(); //ps vs count
        int ps = 0;
        int oans = 0;
        
        map.put(0,1);
        
        for(int i=0; i < nums.length;i++) {
            ps += nums[i];
            
            if(map.containsKey(ps-k) == true) {
                oans += map.get(ps-k);
            }
            
            int nf = map.getOrDefault(ps,0) + 1;
            map.put(ps,nf);
        }
        
        return oans;
    }
}