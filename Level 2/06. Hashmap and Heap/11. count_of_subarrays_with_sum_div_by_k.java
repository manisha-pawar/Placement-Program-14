class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>(); //rem vs  count
        int ps = 0;
        int oans = 0;
        map.put(0,1);
        
        for(int i=0; i < nums.length;i++) {
            ps += nums[i];
            int rem = ps % k;
            
            if(rem < 0) {
                rem += k;
            }
            
            if(map.containsKey(rem) == true) {
                oans += map.get(rem);
            }
            
            int nf = map.getOrDefault(rem,0) + 1;
            map.put(rem,nf);
        }
        
        return oans;
    }
}