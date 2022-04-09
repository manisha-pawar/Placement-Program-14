//https://www.lintcode.com/problem/860/

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */

    StringBuilder sb;

    public int numberofDistinctIslands(int[][] grid) {
        HashSet<String>hs = new HashSet<>();

        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    sb = new StringBuilder();
                    dfs(grid,i,j);
                    hs.add(sb.toString());
                }
            }
        }

        return hs.size();
    }

    public void dfs(int[][]grid,int i,int j) {
        grid[i][j] = 0;

        //top
        if(i-1 >= 0 && grid[i-1][j] == 1) {
            sb.append('t');
            dfs(grid,i-1,j);
        }

        //left
        if(j-1 >= 0 && grid[i][j-1] == 1) {
            sb.append('l');
            dfs(grid,i,j-1);
        }

        //down
        if(i+1 < grid.length && grid[i+1][j] == 1) {
            sb.append('d');
            dfs(grid,i+1,j);
        }

        //right
        if(j+1 < grid[0].length && grid[i][j+1] == 1) {
            sb.append('r');
            dfs(grid,i,j+1);
        }

        //bactracking
        sb.append('b');
    }
}