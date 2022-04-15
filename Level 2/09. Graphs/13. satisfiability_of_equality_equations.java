class Solution {
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
    
    public void union(char ch1,char ch2) {
        int v1 = ch1-'a';
        int v2 = ch2-'a';
        
        int sl1 = find(v1);
        int sl2 = find(v2);
        
        if(sl1 != sl2) {
            //merging
            if(rank[sl1] < rank[sl2]) {
                parent[sl1] = sl2;
            }
            else if(rank[sl2] < rank[sl1]) {
                parent[sl2] = sl1;
            }
            else {
                parent[sl1] = sl2;
                rank[sl2]++;
            }
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i=0; i < 26;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        //1. apply DSU using equality equations
        for(int i=0; i < equations.length;i++) {
            String eqn = equations[i];
            
            if(eqn.charAt(1) == '=') {
                char op1 = eqn.charAt(0);
                char op2 = eqn.charAt(3);
                
                union(op1,op2);
            }
        }
        
        //2. verification using inequalities equations
        for(int i=0; i < equations.length;i++) {
            String eqn = equations[i];
            
            if(eqn.charAt(1) == '!') {
                char op1 = eqn.charAt(0);
                char op2 = eqn.charAt(3);
                
                if(find(op1-'a') == find(op2-'a')) {
                    return false;
                }
            }
        }
        
        return true;
    }
}