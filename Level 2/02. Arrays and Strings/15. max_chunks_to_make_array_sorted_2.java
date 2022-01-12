//https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[]lmax = new int[arr.length];
        int[]rmin = new int[arr.length + 1];
        
        lmax[0] = arr[0];
        
        for(int i=1; i < arr.length;i++) {
            lmax[i] = Math.max(lmax[i-1],arr[i]);
        }
        
        rmin[arr.length] = Integer.MAX_VALUE;
        
        for(int i=arr.length-1; i >= 0;i--) {
            rmin[i] = Math.min(rmin[i+1],arr[i]);
        }
        
        int chunks = 0;
        for(int i=0; i < arr.length;i++) {
            if(lmax[i] <= rmin[i+1]) {
                chunks++;
            }
        }
        
        return chunks;
    }
}