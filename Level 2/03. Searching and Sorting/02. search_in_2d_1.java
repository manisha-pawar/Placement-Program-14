class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int pr = findPotentialRow(matrix,target); //log n
        
        if(pr == -1) {
            return false;
        }
        
        return binarySearch(matrix,pr,target); //log m
    }
    
    public static int findPotentialRow(int[][]matrix,int target) {
        int lo = 0;
        int hi = matrix.length-1;
        int lc = matrix[0].length-1;
        
        while(lo <= hi) {
            
            int m = (lo + hi)/2;
            
            if(matrix[m][0] <= target && matrix[m][lc] >= target) {
                return m;
            }
            else if(matrix[m][0] > target) {
                hi = m-1;
            }
            else {
                lo = m+1;
            }
        }
        
        return -1;
    }
    public static boolean binarySearch(int[][]matrix,int r,int target) {
        int lo = 0;
        int hi = matrix[0].length-1;
        
        while(lo <= hi) {
            
            int m = (lo + hi)/2;
            
            if(matrix[r][m] == target) {
                return true;
            }
            else if(matrix[r][m] < target) {
                lo = m+1;
            }
            else {
                hi = m-1;
            }
        }
        
        return false;
    }
}