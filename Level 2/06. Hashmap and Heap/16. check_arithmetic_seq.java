class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length < 2) {
            return true;
        }
        
        HashSet<Integer>hs = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        for(int i=0; i < arr.length;i++) {
            if(arr[i] < min) {
                smin = min;
                min = arr[i];
            }
            else if(arr[i] < smin) {
                smin = arr[i];
            }
            hs.add(arr[i]);
        }
        
        int cd = smin - min;
        
        if(cd == 0) {
            return hs.size() == 1;
        } 
        
        int term = min;
        
        for(int i = 0; i < arr.length;i++) {
            if(hs.contains(term) == false)  {
                return false;
            } 
            term += cd;
        }
        
        return true;
    }
}