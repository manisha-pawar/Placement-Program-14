class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Long>map = new HashMap<>(); //prefix sum vs count
        map.put(0L,1L);
        long oans = 0;
        long ps = 0;
        
        for(int i=0; i < n;i++) {
            ps += arr[i];
            
            if(map.containsKey(ps) == true) {
                oans += map.get(ps);
            }
            
            long nf = map.getOrDefault(ps,0L) + 1;
            map.put(ps,nf);
        }
        
        return oans;
    }
}