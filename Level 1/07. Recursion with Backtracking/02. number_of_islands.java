//leetcode 200 https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][]vis = new boolean[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                //an unvisited '1'
                if(grid[i][j] == '1' && vis[i][j] == false) {
                    travel(i,j,grid,vis);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void travel(int sr,int sc,char[][]grid,boolean[][]vis) {
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == '0' || vis[sr][sc] == true) {
            return;
        }
        
        vis[sr][sc] = true;
        
        //top
        travel(sr-1,sc,grid,vis);
        
        //left
        travel(sr,sc-1,grid,vis);
        
        //down
        travel(sr+1,sc,grid,vis);
        
        //right
        travel(sr,sc+1,grid,vis);
    }
    
}