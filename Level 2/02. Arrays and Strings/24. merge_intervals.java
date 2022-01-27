class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]>ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        
        ans.add(intervals[0]);
        
        int i = 1;
        
        while(i <  intervals.length) {
            int li = ans.size()-1;
            if(intervals[i][0] <= ans.get(li)[1]) {
                ans.get(li)[1] = Math.max(ans.get(li)[1],intervals[i][1]);
            }
            else {
                ans.add(intervals[i]);
            }
            i++;
        }
        
        int[][]fres = new int[ans.size()][2];
        fres = ans.toArray(fres);
        
        return fres;
        
    }
}