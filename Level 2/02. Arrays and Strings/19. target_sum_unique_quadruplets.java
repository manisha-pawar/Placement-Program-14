class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List < List < Integer >> ans = new ArrayList < > ();
        
        for(int i=0; i < n-3;i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            List<List<Integer>>res = tsUniqueTriplets(nums,i+1,target-nums[i]);
            
            for(List<Integer>list : res) {
                list.add(nums[i]);
                ans.add(list);
            }
        }
        
        return ans;
    }
    
    public static List < List < Integer >> tsUniquePairs(int[] nums, int si, int target) {
        int i = si;
        int j = nums.length - 1;

        List < List < Integer >> ans = new ArrayList < > ();

        while (i < j) {
            if (i != si && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (nums[i] + nums[j] == target) {
                ArrayList < Integer > res = new ArrayList < > ();
                res.add(nums[i]);
                res.add(nums[j]);
                ans.add(res);

                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    public static List < List < Integer >> tsUniqueTriplets(int[] nums,int si,int target) {

        List < List < Integer >> ans = new ArrayList < > ();
        int n = nums.length;

        for (int i = si; i < n - 2; i++) {

            if (i != si && nums[i] == nums[i - 1]) {
                continue;
            }

            List < List < Integer >> res = tsUniquePairs(nums, i + 1, target - nums[i]);

            for (List < Integer > list: res) {
                list.add(nums[i]);
                ans.add(list);
            }
        }

        return ans;
    }
}