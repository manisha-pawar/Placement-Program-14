//1. using gap(c0-c1) as key
class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        HashMap<Integer,Integer>map = new HashMap<>(); //gap(c0-c1) vs count
        int c0 = 0;
        int c1 = 0;
        int oans = 0;
        map.put(0,1);
        
        for(int i=0; i < n;i++) {
            if(arr[i] == 0) {
                c0++;
            }
            else {
                c1++;
            }
            
            int gap = c0-c1;
            
            if(map.containsKey(gap) == true) {
                oans += map.get(gap);
            }
            
            int nf = map.getOrDefault(gap,0) + 1;
            map.put(gap,nf);
        }
        
        return oans;
    }
}



//2. using count of all subarrays having sum = 0
class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    { 
        //replace 0 with -1
        for(int i=0; i < n;i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }
        
        //apply count of subarrays having sum=0
        HashMap<Integer,Integer>map = new HashMap<>(); //gap(c0-c1) vs count
        int oans = 0;
        int ps = 0;
        map.put(0,1);
        
        for(int i=0; i < n;i++) {
           ps += arr[i];
           
           if(map.containsKey(ps) == true) {
               oans += map.get(ps);
           }
           
           int nf = map.getOrDefault(ps,0) + 1;
           map.put(ps,nf);
        }
        
        return oans;
    }
}
