/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    static class Pair {
        int lzzp; //left zig-zag path (starting from node)
        int rzzp; //right zig-zag path(starting from node)
        int mzzp;
        
        Pair() {
            
        }
        
        Pair(int lzzp,int rzzp,int mzzp) {
            this.lzzp = lzzp;
            this.rzzp = rzzp;
            this.mzzp = mzzp;
        }
    }
    
    
    public int longestZigZag(TreeNode root) {
        Pair bp = helper(root);
        return bp.mzzp;
    }
    
    public Pair helper(TreeNode node) {
        if(node == null) {
            return new Pair(-1,-1,0);
        }

        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        int lzzp = 1 + lp.rzzp;
        int rzzp = 1 + rp.lzzp;
        int mzzp = max(lp.mzzp,rp.mzzp,lzzp,rzzp);
        
        return new Pair(lzzp,rzzp,mzzp);
        
    }
    
    
    //var-args (variable arguments)
    public int max(int...arr) {
        int max = arr[0];
        
        for(int i=1; i < arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max;
    }
}
