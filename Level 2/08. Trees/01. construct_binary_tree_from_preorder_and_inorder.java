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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder,inorder,0,n-1,0,n-1);
    }
    
    public TreeNode helper(int[]preorder,int[]inorder,int ps,int pe,int is,int ie) {
        if(ps > pe) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[ps]);
        
        int idx = -1;
        for(int i = is; i <= ie;i++) {
            if(inorder[i] == node.val) {
                idx = i;
                break;
            }
        }
        
        int colse = idx - is;
        node.left = helper(preorder,inorder,ps+1,ps+colse,is,idx-1);
        node.right = helper(preorder,inorder,ps+colse+1,pe,idx+1,ie);
        
        return node;
    }
    
}