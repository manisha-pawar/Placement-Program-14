class Solution {
      public List<List<Integer>> targetSumUniquePairs(int si,int[] arr, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        
        int i = si;
        int j = arr.length-1;
        
        while(i < j) {
            if(i-1 >= si && arr[i] == arr[i-1]) {
                i++;
                continue;
            }
            
            if(arr[i] + arr[j] == target) {
                ArrayList<Integer>pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[j]);
                ans.add(pair);
                
                i++;
                j--;
            }
            else if(arr[i] + arr[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        
        return ans;
    }
    
    
    public List<List<Integer>> targetSumUniqueTriplet(int si,int[] nums,int target) {
        //target sum unique triplet
        List<List<Integer>>ans = new ArrayList<>();
        
        for(int i=si; i < nums.length-2 ;i++) {
            if(i-1 >= si && nums[i] == nums[i-1]) {
                continue;
            }
            
            List<List<Integer>>sl = targetSumUniquePairs(i+1,nums,target-nums[i]);
            
            for(int k=0;k < sl.size();k++) {
                sl.get(k).add(nums[i]); //pair to triplet
                ans.add(sl.get(k));
            }
        }
        
        return ans;   
    }
    
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i < nums.length-3;i++) {
            if(i-1 >= 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            List<List<Integer>>sl = targetSumUniqueTriplet(i+1,nums,target-nums[i]);
            
            for(int k=0; k < sl.size();k++) {
                sl.get(k).add(nums[i]); //triplet to quadraple
                ans.add(sl.get(k));
            }
        }
        
        return ans;
    }
    
    
}