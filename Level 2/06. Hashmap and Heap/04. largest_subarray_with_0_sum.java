class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer>map = new HashMap<>(); //prefix sum vs first idx
        map.put(0,-1);
        int ps = 0;
        int olen = 0;
        
        for(int i=0; i < n;i++) {
            ps += arr[i];
            
            if(map.containsKey(ps) == true) {
                int len = i - map.get(ps);
                olen = Math.max(len,olen);
            }
            else {
                map.put(ps,i);
            }
        }
        
        return olen;
        
    }
}