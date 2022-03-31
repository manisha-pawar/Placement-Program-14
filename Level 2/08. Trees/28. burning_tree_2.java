import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static HashMap < Integer, ArrayList < Integer >> map; //total time taken to burn the complete tree

    public static void Kdown(TreeNode node, int t, TreeNode bn) {
        if (node == null || node == bn) {
            return;
        }

        ArrayList < Integer > list = map.getOrDefault(t, new ArrayList < > ());
        list.add(node.val);
        map.put(t, list);

        Kdown(node.left, t + 1, bn);
        Kdown(node.right, t + 1, bn);
    }

    public static ArrayList < ArrayList < Integer >> burningTree(TreeNode root, int data) {
        map = new HashMap < > ();
        ArrayList < TreeNode > n2rp = nodeToRootPath(root, data);

        int t = 0;
        TreeNode bn = null;

        for (int i = 0; i < n2rp.size(); i++) {
            Kdown(n2rp.get(i), t, bn);
            t++;
            bn = n2rp.get(i);
        }

        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        for (int key = 0; key < map.size(); key++) {
            ans.add(map.get(key));
        }

        return ans;
    }

    public static ArrayList < TreeNode > nodeToRootPath(TreeNode node, int data) {
        if (node == null) {
            return new ArrayList < > ();
        }

        if (node.val == data) {
            ArrayList < TreeNode > list = new ArrayList < > ();
            list.add(node);
            return list;
        }

        ArrayList < TreeNode > n2lcp = nodeToRootPath(node.left, data);

        if (n2lcp.size() > 0) {
            n2lcp.add(node);
            return n2lcp;
        }

        ArrayList < TreeNode > n2rcp = nodeToRootPath(node.right, data);

        if (n2rcp.size() > 0) {
            n2rcp.add(node);
            return n2rcp;
        }


        return new ArrayList < > ();
    }


    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        int fireNode = scn.nextInt();

        ArrayList < ArrayList < Integer >> ans = burningTree(root, fireNode);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList < Integer > ar: ans) {
            for (Integer ele: ar)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}