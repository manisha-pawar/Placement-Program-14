class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    static long count = 0; //total inversions
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        count = 0;
        mergeSort(arr,0,(int)(N-1));
        return count;
    }
    
    public static long[] merge2SortedArrays(long[]left,long[]right) {
        int n = left.length;
        int m = right.length;
        long[]ma = new long[n+m];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < n && j < m) {
            if(left[i] <= right[j]) {
                ma[k] = left[i];
                i++;
                k++;
            }
            else {
                //calculate inversions
                count += (left.length - i);
                ma[k] = right[j];
                j++;
                k++;
            }
        }
        
        while(i < n) {
            ma[k] = left[i];
            i++;
            k++;
        }
        
        while(j < m) {
            ma[k] = right[j];
            j++;
            k++;
        }
        
        return ma;
    }
    public static long[] mergeSort(long[]arr,int lo,int hi) {
        if(lo == hi) {
            long[]ba = new long[1];
            ba[0] = arr[lo];
            return ba;
        }
        
        int mid = (lo + hi)/2;
        long[]la = mergeSort(arr,lo,mid);
        long[]ra = mergeSort(arr,mid+1,hi);
        
        return merge2SortedArrays(la,ra);
    }
}