//https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0;j < grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}}; //tldr
    
    public void dfs(char[][]grid,int i,int j) {
        
        grid[i][j] = '0';
        
        for(int k = 0; k < 4;k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == '1') {
                dfs(grid,ni,nj);
            }
        }
    }
}