class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        long ans = Integer.MAX_VALUE;
        Collections.sort(a);
        
        
        for(int i=0; i <= (int)(n-m);i++) {
            //window i to i + m - 1
            long minw = a.get(i);
            long maxw = a.get(i + (int)m - 1);
            long gap = maxw - minw;
            
            ans = Math.min(ans,gap);
        }
        
        return ans;
    }
}