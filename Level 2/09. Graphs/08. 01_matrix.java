//https://leetcode.com/problems/01-matrix/

class Solution {
    static class Pair {
        int i;
        int j;
        int dist;
        
        Pair(int i,int j,int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][]ans = new int[m][n];
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i,j,0));
                }
                else {
                    ans[i][j] = -1; //not solved
                }
            }
        }
        
        
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            for(int k=0; k < 4;k++) {
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && ans[ni][nj] == -1) {
                    q.add(new Pair(ni,nj,rem.dist + 1));
                    ans[ni][nj] = rem.dist + 1;
                }
            }
        }
        
        return ans;
    }
}