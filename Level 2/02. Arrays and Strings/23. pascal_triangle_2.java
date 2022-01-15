//https://leetcode.com/problems/pascals-triangle-ii/

class Solution {
    public List<Integer> getRow(int n) {
        List<Integer>ans = new ArrayList<>();
        
        long val = 1; // nC0
        ans.add(1);
        
        for(int r = 0; r < n; r++) {
            val = (val * (n - r)) / (r + 1);
            ans.add((int)val);
        }
        
        return ans;
    }
}