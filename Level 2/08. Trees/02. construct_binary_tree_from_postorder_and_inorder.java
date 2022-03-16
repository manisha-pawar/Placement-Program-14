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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(postorder,inorder,0,n-1,0,n-1);
    }
    
    public TreeNode helper(int[]postorder,int[]inorder,int ps,int pe,int is,int ie) {
        if(ps > pe) {
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[pe]);
        
        int idx = -1;
        for(int i=is; i <= ie;i++) {
            if(inorder[i] == node.val) {
                idx = i;
                break;
            }
        }
        int colse = idx-is;
        
        node.left = helper(postorder,inorder,ps,ps+colse-1,is,idx-1);
        node.right = helper(postorder,inorder,ps+colse,pe-1,idx+1,ie);
        
        return node;
    }
    
    
}