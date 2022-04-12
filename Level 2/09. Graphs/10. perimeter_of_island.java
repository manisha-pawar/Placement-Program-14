//1. travelling the island using dfs
class Solution {
    int count = 0;
    public int islandPerimeter(int[][] grid) {
        
        count = 0;
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid,i,j);
                }
            }
        }
        
        return count;
        
    }
    
    
    public void dfs(int[][]grid,int i,int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            count++;
            return;
        }
        
        if(grid[i][j] == 2) {
            return;
        }
        
        grid[i][j] = 2;
        
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);

    }
}




//2. travelling the matrix
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                if(grid[i][j] == 1) {
                    //top
                    if(i-1 == -1 || grid[i-1][j] == 0) {
                        count++;
                    }
                    
                    //left
                    if(j-1 == -1 || grid[i][j-1] == 0) {
                        count++;
                    }
                    
                    //down
                    if(i+1 == m || grid[i+1][j] == 0) {
                        count++;
                    }
                    
                    //right
                    if(j+1 == n || grid[i][j+1] == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}