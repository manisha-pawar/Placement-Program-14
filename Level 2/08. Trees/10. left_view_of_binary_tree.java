class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
       ArrayList<Integer>lv = new ArrayList<>(); //left view
       
       helper(root,0,lv);
       
       return lv;
    }
    
    public void helper(Node node,int lev,ArrayList<Integer>lv) {
        if(node == null) {
            return;
        }
        
        if(lv.size() == lev) {
            lv.add(node.data);
        }
        
        helper(node.left,lev+1,lv);
        helper(node.right,lev+1,lv);
    }
}