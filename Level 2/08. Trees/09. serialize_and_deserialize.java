/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "n";
        }
        
        String la = serialize(root.left);
        String ra = serialize(root.right);
        
        return root.val + " " + la + " " +ra;
    }

    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        String[]arr = data.split(" ");
        idx = 0;
        
        return helper(arr);
    }
    
    public TreeNode helper(String[]arr) {
        if(arr[idx].equals("n") == true) {
            idx++;
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(arr[idx]));
            idx++;
            node.left = helper(arr);
            node.right = helper(arr);
            
            return node;
        }
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));