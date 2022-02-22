public class Solution {
    
    public int maxSubArrayLen(int[] A, int k) {
        HashMap<Integer,Integer>map = new HashMap<>(); //ps vs first idx
        int olen = 0;
        int ps = 0;
        map.put(0,-1);
        
        for(int i=0; i < A.length;i++) {
            ps += A[i];
            
            if(map.containsKey(ps-k) == true) {
                int len = i - map.get(ps-k);
                olen = Math.max(olen,len);
            }
            
            map.put(ps,map.getOrDefault(ps,i));
        }
        
        return olen;
    }
}