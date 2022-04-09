//https://leetcode.com/problems/rotting-oranges/

class Solution {
    static class Pair {
        int i;
        int j;
        int t;
        
        Pair(int i,int j,int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
        
        Pair() {
            
        }
    }
    
    
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair>q = new ArrayDeque<>();
        int fo = 0; //fresh oranges
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1) {
                    fo++;
                }
            }
        }
        
        
        int time = 0;
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        //bfs
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            time = Math.max(time,rem.t);
            
            //add unvis and mark them as well
            for(int k = 0; k < 4;k++) {
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
                    q.add(new Pair(ni,nj,rem.t+1));
                    grid[ni][nj] = 2;
                    fo--;
                } 
            }
        }
        
        if(fo == 0) {
            return time;
        }
        else {
            return -1;
        }
        
        
    }    
}