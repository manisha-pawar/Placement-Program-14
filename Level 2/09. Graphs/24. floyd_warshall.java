class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        
        int n = matrix.length;
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < n;j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int k = 0; k < n;k++) {
            for(int u = 0; u < n;u++) {
                for(int v = 0; v < n;v++) {
                    //use k as intermediate 
                    if(k != u && k != v && u != v && matrix[u][k] != Integer.MAX_VALUE && matrix[k][v] != Integer.MAX_VALUE && matrix[u][k] + matrix[k][v] < matrix[u][v]) {
                        matrix[u][v] = matrix[u][k] + matrix[k][v];
                    }
                }
            }
        }
        
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < n;j++) {
                if(matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}