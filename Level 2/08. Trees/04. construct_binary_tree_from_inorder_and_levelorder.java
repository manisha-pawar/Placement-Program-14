class GfG
{
    HashMap<Integer,Integer>map; //element vs its index in inorder
    
    Node buildTree(int inorder[], int level[])
    {
        map = new HashMap<>();
        for(int i=0; i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(inorder,level,0,inorder.length-1);
        
    }
    
    Node helper(int[]inorder,int[]level,int is,int ie) {
        if(is > ie) {
            return null;
        }
        
        Node node = new Node(level[0]);
        int idx = map.get(node.data);
        int colse = idx - is;
        int corse = ie - idx;
        
        int[]llo = new int[colse];
        int[]rlo = new int[corse];
        
        segregateLevelOrder(llo,rlo,level,idx);
        
        node.left = helper(inorder,llo,is,idx-1);
        node.right = helper(inorder,rlo,idx+1,ie);
        
        return node;
    }
    
    void segregateLevelOrder(int[]llo,int[]rlo,int[]level,int idx) {
        int j = 0;
        int k = 0;
        
        for(int i=1; i < level.length;i++) {
            if(map.get(level[i]) < idx) {
                //belongs to left-substree
                llo[j++] = level[i];
            }
            else {
                //belongs to right-subtree
                rlo[k++] = level[i];
            }
        }
    }
       
}


