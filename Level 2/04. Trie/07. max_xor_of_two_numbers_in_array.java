class Solution {
    static class Node {
        Node left; //0
        Node right; //1
        
        Node() {
            
        }
        
        Node(Node left,Node right) {
            this.left = left;
            this.right = right;
        }
    }
    
    Node root;
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        
        for(int val : nums) {
            insert(val);
        }
        
        
        int max = 0;
        for(int i=0; i < nums.length;i++) {
            int a = nums[i];
            int b = a ^ Integer.MAX_VALUE;
            int res = search(b);
            int ans = a ^ res;
            max = Math.max(max,ans);
        }
        
        return max;
    }
    
    public int search(int key) {
        int idx = 30; //right most bit index
        Node curr = root;
        int ans = 0;
        
        while(idx >= 0) {
            int mask = (1 << idx);
            int bit = (mask & key) == 0 ? 0 : 1; //desire
            
            //check availability
            if(bit == 0) {
                if(curr.left != null) {
                    //desired bit is available
                    curr = curr.left;
                }
                else {
                    //desired bit is not available
                    ans = ans | mask; 
                    curr = curr.right;
                }
            }
            else {
                if(curr.right != null) {
                    //desired bit is available
                    ans = ans | mask;
                    curr = curr.right;
                }
                else {
                    //desired bit is not available
                    curr = curr.left;
                }
            }
            
            idx--;
        }
        
        return ans;
    }
    
    
    public void insert(int val) {
        int idx = 30; // right most bit index
        Node curr = root;
        
        while(idx >= 0) {
            int mask = 1 << idx;
            int bit = (mask & val) == 0 ? 0 : 1;
            
            if(bit == 0) {
                if(curr.left == null) {
                    curr.left = new Node();
                }
                curr = curr.left;
            }
            else {
                if(curr.right == null) {
                    curr.right = new Node();
                }
                curr = curr.right;
            }
            
            idx--;
        }
    }
}
