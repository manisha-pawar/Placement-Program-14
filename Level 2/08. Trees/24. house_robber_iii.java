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
        int incMP; //inclusion max profit (node is inc)
        int excMP; //exclusion max profit (node is exc)
        
        Pair() {
            
        }
        
        Pair(int incMP,int excMP) {
            this.incMP = incMP;
            this.excMP = excMP;
        }
    }
    
    public int rob(TreeNode root) {
        Pair bp = helper(root); //base pair 
        
        return Math.max(bp.incMP,bp.excMP);
    }
    
    
    public Pair helper(TreeNode node) {
        if(node == null) {
            return new Pair(0,0);
        }
        
        Pair lp = helper(node.left); //left pair
        Pair rp = helper(node.right); //right pair
        
        int incMP = lp.excMP + rp.excMP + node.val;
        int excMP = Math.max(lp.incMP,lp.excMP) + Math.max(rp.incMP,rp.excMP);
        
        return new Pair(incMP,excMP);
    }

}