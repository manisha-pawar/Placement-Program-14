//https://www.lintcode.com/problem/434/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    
    int[]parent;
    int[]rank;

    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        int sl = find(parent[x]);
        parent[x] = sl;
        return sl;
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        parent = new int[n*m];
        rank = new int[n*m];
        int[][]mat = new int[n][m];
        List<Integer>ans = new ArrayList<>();

        for(int i=0; i < n*m;i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int count = 0;
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};

        for(int k=0; k < operators.length;k++) {
            int i = operators[k].x;
            int j = operators[k].y;

            if(mat[i][j] == 1) {
                ans.add(count);
                continue;
            }
            
            mat[i][j] = 1;
            count++;

            for(int d=0;d < 4;d++) {
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    int s1 = find(i*m + j);
                    int s2 = find(ni*m + nj);

                    if(s1 != s2) {
                        //merging
                        if(rank[s1] < rank[s2]) {
                            parent[s1] = s2;
                        }
                        else if(rank[s2] < rank[s1]) {
                            parent[s2] = s1;
                        }
                        else {
                            parent[s1] = s2;
                            rank[s2]++;
                        }
                        count--;
                    }                    
                }
            }
            
            ans.add(count);
        }

        return ans;

    }

}