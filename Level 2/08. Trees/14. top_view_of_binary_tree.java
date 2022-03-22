class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
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
    
    
    
    static ArrayList<Integer> topView(Node root)
    {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        helper(root,0);
        
        int w = lx - sx + 1;
        ArrayList<Integer>tv = new ArrayList<>();
        
        for(int i=0; i < w;i++) {
            tv.add(-1);
        }
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        q.add(new Pair(root,-sx));
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            
            //work
            if(tv.get(rem.x) == -1) {
                tv.set(rem.x,rem.node.data);
            }
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.x-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.x+1));
            }
        }
        
        return tv;
    }

}