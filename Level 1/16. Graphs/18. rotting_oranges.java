//https://leetcode.com/problems/rotting-oranges/

class Solution {
    static class Pair {
        int r;
        int c;
        int t;
        
        Pair(int r,int c,int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
  
    public int orangesRotting(int[][] grid) {
        int fo = 0;
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    fo++;
                }
                else if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        if(fo == 0) {
            return 0;
        }
        
        
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}}; //tldr
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(grid[rem.r][rem.c] == -1) {
                continue;
            }
            else if(grid[rem.r][rem.c] == 1) {
                fo--;
            }
            grid[rem.r][rem.c] = -1;
            
            if(fo == 0) {
                return rem.t;
            }
            
            for(int i=0; i < 4;i++) {
                int nr = rem.r + dir[i][0];
                int nc = rem.c + dir[i][1];
                
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new Pair(nr,nc,rem.t+1));
                }
            }
            
        }
        
        
        return -1;
    }
}