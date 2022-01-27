class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        
        ArrayList<int[]>list = new ArrayList<>();
        
        while(i < firstList.length && j < secondList.length) {
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
            
            int sp = Math.max(s1,s2);
            int ep = Math.min(e1,e2);
            
            if(sp <= ep) { 
                list.add(new int[]{sp,ep});
            }
            
            if(e1 < e2) {
                i++;
            }
            else {
                j++;
            }
        }
        
        
        int[][]fres = new int[list.size()][2];
        fres = list.toArray(fres);
        
        return fres;
    }
}