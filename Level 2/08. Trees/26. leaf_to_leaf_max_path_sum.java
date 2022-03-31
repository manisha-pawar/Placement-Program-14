class Solution {
    static class Pair {
        int n2l; //node to leaf
        int l2l; //leaf to leaf

        Pair() {

        }

        Pair(int n2l, int l2l) {
            this.n2l = n2l;
            this.l2l = l2l;
        }
    }

    public Pair helper(Node node) {
        if (node == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        if (node.left == null && node.right == null) {
            return new Pair(node.data, Integer.MIN_VALUE);
        }

        Pair lp = helper(node.left);
        Pair rp = helper(node.right);

        int n2l = Math.max(lp.n2l, rp.n2l) + node.data;

        int l2l = Math.max(lp.l2l, rp.l2l);

        if (node.left != null && node.right != null) {
            l2l = Math.max(l2l, lp.n2l + node.data + rp.n2l);
        }

        return new Pair(n2l, l2l);
    }

    int maxPathSum(Node root) {
        Pair rp = helper(root);

        //due to note : if root has only one child, it is considered as Leaf
        if (root.left != null && root.right == null || root.left == null && root.right != null) {
            return Math.max(rp.l2l, rp.n2l);
        }

        return rp.l2l;
    }
}