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
    int cam;
    
    
    public int minCameraCover(TreeNode root) {
        int rs = helper(root);
        
        if(rs == 0) {
            cam++;
        }
        
        return cam;
    }
    
    
    //0 -> needs coverage
    //1 -> camera
    //2 -> covered
    
    
    public int helper(TreeNode node) {
        if(node == null) {
            return 2;    
        }
        
        int lci = helper(node.left); //left child indication
        int rci = helper(node.right); //right child indication
        
        if(lci == 0 || rci == 0) {
            cam++; //put a camera on node
            return 1;
        }
        else if(lci == 1 || rci == 1) {
            return 2; //node is covered
        }
        else {
            return 0;
        }
    }
}