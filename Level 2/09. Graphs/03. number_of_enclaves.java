//https://leetcode.com/problems/number-of-enclaves/

class Solution {
    public int numEnclaves(int[][] grid) {
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                //boundary's 1
                if((i == 0 || i == grid.length-1 || j == 0 || j == grid[0].length-1) && grid[i][j] == 1) {
                    dfs(grid,i,j);
                } 
            }
        }
        
        
        //remaining ones in the grid are enclaves
        int count = 0;
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    public void dfs(int[][]grid,int i,int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        
        grid[i][j] = 0;
        
        dfs(grid,i-1,j); //top
        dfs(grid,i,j-1); //left
        dfs(grid,i+1,j); //down
        dfs(grid,i,j+1); //right
    }
}