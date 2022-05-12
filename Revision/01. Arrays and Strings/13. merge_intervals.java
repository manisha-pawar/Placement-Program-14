//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            //-ve -> this < o
            //+ve -> this > o
            //0 -> this == o
            return a[0] - b[0];
        });
        
        
        int[]li = {0,0}; //last merged interval's result
        ArrayList<int[]>ans = new ArrayList<>();
        
        li[0] = intervals[0][0];
        li[1] = intervals[0][1];
        
        
        for(int i=1; i < intervals.length;i++) {
            int cisp = intervals[i][0];
            int ciep = intervals[i][1];
            int liep = li[1];
            
            if(liep >= cisp) {
                //merging is possible
                li[1] = Math.max(li[1],ciep);
            }
            else {
                int[]narr = {li[0],li[1]};
                ans.add(narr);
                li[0] = cisp;
                li[1] = ciep;
            }
            
        }

        int[]narr = {li[0],li[1]};
        ans.add(narr);
        
        int[][]fans = new int[ans.size()][2];
        fans = ans.toArray(fans);
        
        return fans;
    }
}