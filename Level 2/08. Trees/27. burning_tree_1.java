class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static int time; //total time taken to burn the complete tree
    
    public static void Kdown(Node node,int t,Node bn) {
        if(node == null || node == bn) {
            return;
        }
        
        time = Math.max(time,t);
        
        Kdown(node.left,t+1,bn);
        Kdown(node.right,t+1,bn);
    }
    
    public static int minTime(Node root, int target) 
    {
        time = 0;
        ArrayList<Node>n2rp = nodeToRootPath(root,target);
        
        int t = 0;
        Node bn = null;
        
        for(int i=0; i < n2rp.size();i++) {
            Kdown(n2rp.get(i),t,bn);
            t++;
            bn = n2rp.get(i);
        }
        
        return time;
    }
    
    public static ArrayList<Node> nodeToRootPath(Node node,int data) {
        if(node == null) {
            return new ArrayList<>();
        }
        
        if(node.data == data) {
            ArrayList<Node>list = new ArrayList<>();
            list.add(node);
            return list;
        }
        
        ArrayList<Node>n2lcp = nodeToRootPath(node.left,data);
        
        if(n2lcp.size() > 0) {
            n2lcp.add(node);
            return n2lcp;
        }
        
        ArrayList<Node>n2rcp = nodeToRootPath(node.right,data);
        
        if(n2rcp.size() > 0) {
            n2rcp.add(node);
            return n2rcp;
        }
        
        
        return new ArrayList<>();
    }  
}