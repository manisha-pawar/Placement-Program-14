/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */

    TreeNode prev;
    public TreeNode treeToDoublyList(TreeNode root) {
        TreeNode dh = new TreeNode(-1);
        prev = dh;

        helper(root);
        TreeNode head = dh.right;
        TreeNode tail = prev;

        //dll -> cdll
        head.left = tail;
        tail.right = head;

        return head;
    }

    public void helper(TreeNode curr) {
        if(curr == null) {
            return;
        }

        helper(curr.left);

        //work
        prev.right = curr;
        curr.left = prev;
        prev = curr;

        helper(curr.right);
    }
}
