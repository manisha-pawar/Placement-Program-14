class GFG
{
    static int idx;
    public static Node constructTree(int post[],int n)
    {
        idx = n-1;
        return helper(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public static Node helper(int[]post,int lr,int rr) {
        if(idx < 0 || post[idx] < lr || post[idx] > rr) {
            return null;
        }
        else {
            Node node = new Node(post[idx]);
            idx--;
            
            node.right = helper(post,node.data,rr);
            node.left = helper(post,lr,node.data);
            
            return node;
        }
    }

}