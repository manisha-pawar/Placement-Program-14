class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        
        for(int[]trip : trips) {
            int ep = trip[2];
            max = Math.max(max,ep);
        }
        
        int[]arr = new int[max+1];
        
        for(int[]trip : trips) {
            int np = trip[0];
            int sp = trip[1];
            int ep = trip[2];
            
            arr[sp] += np;
            arr[ep] -= np;
        }
        
        int ps = 0;
        
        for(int i = 0; i < arr.length;i++) {
            ps += arr[i];
            
            if(ps > capacity) {
                return false;
            }   
        }
        
        return true;
    }
}