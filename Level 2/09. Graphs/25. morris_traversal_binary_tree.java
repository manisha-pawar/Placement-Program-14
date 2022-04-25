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
    
    public TreeNode rightMostNode(TreeNode ln,TreeNode curr) {
        TreeNode temp = ln;
        
        while(temp.right != null && temp.right != curr) {
            temp = temp.right;
        }
        
        return temp;
    }
    
    

    //morris inorder traversal, space : O(1) ,  time : O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null) {
            TreeNode ln = curr.left;
            
            if(ln == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode rmn = rightMostNode(ln,curr);
                
                if(rmn.right == null) {
                    //left subtree is unvisited
                    rmn.right = curr;
                    curr = curr.left;
                }
                else {
                    //left subtree is visited
                    rmn.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }



    //morris preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null) {
            TreeNode ln = curr.left;
            
            if(ln == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode rmn = rightMostNode(ln,curr);
                
                if(rmn.right == null) {
                    //left subtree is unvisited
                    ans.add(curr.val);
                    rmn.right = curr;
                    curr = curr.left;
                }
                else {
                    //left subtree is visited
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }
}
