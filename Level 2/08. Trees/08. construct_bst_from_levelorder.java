class GFG 
{
    static class Pair {
        int lr;
        int rr;
        Node parent;
        
        Pair() {
            
        }
        
        Pair(int lr,int rr,Node parent) {
            this.lr=  lr; //left range
            this.rr = rr; //right range
            this.parent = parent;
        }
    }
    
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        Node root = null;
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        Pair bp = new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,null);
        q.add(bp);
        
        int idx = 0;
        
        while(idx < arr.length) {
            Pair rem = q.remove();
            
            if(arr[idx] < rem.lr || arr[idx] > rem.rr) {
                //out of range 
                continue;
            }
            else {
                Node child = new Node(arr[idx]);
                idx++;
                
                if(rem.parent == null) {
                    root = child;
                }
                else if(rem.parent.data > child.data) {
                    rem.parent.left = child;
                }
                else {
                    rem.parent.right = child;
                }
                
                Pair lp = new Pair(rem.lr,child.data,child);
                Pair rp = new Pair(child.data,rem.rr,child);
                
                q.add(lp);
                q.add(rp);
            }
        }
        

        return root;
    }
}