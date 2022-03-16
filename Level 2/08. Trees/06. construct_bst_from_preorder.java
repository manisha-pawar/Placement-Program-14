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
    static int idx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0; 
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public TreeNode helper(int[]preorder,int lr,int rr) {
        if(idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(preorder[idx]);
            idx++;
            
            node.left = helper(preorder,lr,node.val);
            node.right = helper(preorder,node.val,rr);
            
            return node;
        }
    }

}