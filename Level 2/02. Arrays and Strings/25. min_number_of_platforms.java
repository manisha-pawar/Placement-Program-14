class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0;
        int j = 0;
        int c = 0;
        int max = 0;
        
        while(i < arr.length && j < dep.length) {
            if(arr[i] <= dep[j]) {
                c++;
                i++;
            }
            else {
                c--;
                j++;
            }
            max = Math.max(c,max);
        }
        
        
        return max;
    }
    
}

