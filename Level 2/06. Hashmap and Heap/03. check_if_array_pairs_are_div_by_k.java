class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer>map = new HashMap<>(); //rem vs count
        
        for(int i=0; i < arr.length;i++) {
            int rem = arr[i] % k;
            
            if(rem < 0) {
                rem += k;
            }
            
            if(map.containsKey(rem) == false) {
                map.put(rem,1);
            }
            else {
                int nf = map.get(rem) + 1;
                map.put(rem,nf);
            }
        }
        
        for(int rem : map.keySet()) {
            if(rem == 0 || (k % 2 == 0 && rem == k/2)) {
                int f = map.get(rem);
                
                if(f % 2 == 1) {
                    return false;
                } 
                else {
                    continue;
                }
            }
            
            int f1 = map.get(rem);
            int f2 = map.getOrDefault(k - rem,-1);
            
            if(f2 == -1 || f1 != f2) {
                return false;
            }
            
        }
        
        return true;
    }
}