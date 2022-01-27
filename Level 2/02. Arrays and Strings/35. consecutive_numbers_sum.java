class Solution {
    public int consecutiveNumbersSum(int n) {
        //brute force
        int count = 0;
        
        for(int k = 1; k*k + k <= 2*n;k++) {
            
           int num = n - (k * (k-1)/2);
            
           if(num % k == 0) {
               //x will be a pos integer
               count++;
           }
        }
        
        return count;
    }
}