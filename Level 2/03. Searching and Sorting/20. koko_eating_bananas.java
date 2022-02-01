class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        
        for(int val : piles) {
            max = Math.max(max,val);
        }
        
        if(h == piles.length) {
            return max;
        }
        
        int lo = 0, hi = max;
        int ans = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isPossible(piles,mid,h) == true) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    
    public static boolean isPossible(int[]piles,int sp,int h) {
        int t = 0;
        
        for(int i=0; i < piles.length;i++) {
            t += Math.ceil(piles[i]*1.0 / sp);
        }
        
        return t <= h;
    }
}