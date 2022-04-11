class Solution {
    static class Pair {
        int i;
        int j;
        int lev;
        
        Pair(int i,int j,int lev) {
            this.i = i;
            this.j = j;
            this.lev = lev;
        }
    }
        
    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair>q = new ArrayDeque<>();
        boolean flag = true;
        
        for(int i=0; i < grid.length && flag;i++) {
            for(int j=0; j < grid[0].length && flag;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid,i,j,q);
                    flag = false;
                }
            }
        } 
        
        
        
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        while(q.size() > 0) {
            Pair rem  = q.remove();
            
            for(int k = 0; k < 4;k++) {
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length) {
                    if(grid[ni][nj] == 0) {
                        q.add(new Pair(ni,nj,rem.lev + 1));
                        grid[ni][nj] = 2;
                    }
                    else if(grid[ni][nj] == 1) {
                        return rem.lev;
                    }
                }
            }
             
        }
        
         return -1;
    }
    
    public void dfs(int[][]grid,int i,int j, ArrayDeque<Pair>q) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        
        grid[i][j] = 2;
        q.add(new Pair(i,j,0));
        
        dfs(grid,i-1,j,q);
        dfs(grid,i,j-1,q);
        dfs(grid,i+1,j,q);
        dfs(grid,i,j+1,q);
    }
}