class Solution {
    int m = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        if(k == 1) {
            return OneArrKadanes(arr);
        }
        
        int sum = 0;
        for(int val : arr) {
            sum = sum + val;
        }
        
        
        int res = TwoArrKadanes(arr);
        
        if(sum > 0) {
            long ans = res + ((long)(k-2) * sum);
            return (int)(ans % m);
        }
        else {
            return res;
        }
    }
    
    
    public int TwoArrKadanes(int[]arr) {
        int csum = arr[0];
        int msum = Math.max(csum,0);
        
        for(int i=1; i < 2*arr.length;i++) {
            int idx = i % arr.length;
            if(csum > 0) {
                csum = csum + arr[idx];
            }
            else {
                csum = arr[idx];
            }
            
            msum = Math.max(csum,msum);
        }
        
        return msum;
    }
    
    public int OneArrKadanes(int[]arr) {
        int csum = arr[0];
        int msum = Math.max(csum,0);
        
        for(int i=1; i < arr.length;i++) {
            if(csum > 0) {
                csum = csum + arr[i];
            }
            else {
                csum = arr[i];
            }
            
            msum = Math.max(csum,msum);
        }
        
        return msum;
    }
}