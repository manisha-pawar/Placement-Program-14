//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0,nums.length-1,nums);
    }
    
    public TreeNode helper(int lo,int hi,int[]nums) {
        if(lo > hi) {
            return null;
        }
        
        int mid = (lo + hi)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = helper(lo,mid-1,nums);
        node.right = helper(mid+1,hi,nums);
        
        return node;
    }
  
}