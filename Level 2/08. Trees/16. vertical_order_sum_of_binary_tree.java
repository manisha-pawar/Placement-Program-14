class Solution{
     static class Pair {
        Node node;
        int x;
        
        Pair() {
            
        }
        
        Pair(Node node,int x) {
            this.node = node;
            this.x = x;
        }
    }
    
    static int sx;
    static int lx;
    
    public static void helper(Node node,int x) {
        if(node == null) {
            return;
        }
        
        sx = Math.min(sx,x);
        lx = Math.max(lx,x);
        
        helper(node.left,x-1);
        helper(node.right,x+1);
    }
    
    
    public ArrayList <Integer> verticalSum(Node root) {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        helper(root,0);
        
        int w = lx - sx + 1;
        ArrayList<Integer>ans = new ArrayList<>();
        
        for(int i=0; i < w;i++) {
            ans.add(0);
        }
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        q.add(new Pair(root,-sx)); //origin shift
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            int nv = ans.get(rem.x) + rem.node.data;
            ans.set(rem.x,nv);
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.x-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.x+1));
            }
        }
        
        return ans;
    }
}
