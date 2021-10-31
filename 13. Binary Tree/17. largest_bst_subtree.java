import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }



    public static class LBSTPair {
        int min;
        int max;
        boolean isBST;
        Node node; //largest bst subtree node
        int size; //largest bst subtree size

        LBSTPair(int min, int max, boolean isBST, Node node, int size) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.node = node;
            this.size = size;
        }
    }

    public static LBSTPair largestBSTSubtree(Node node) {
        if (node == null) {
            return new LBSTPair(Integer.MAX_VALUE, Integer.MIN_VALUE, true, null, 0);
        }

        LBSTPair lp = largestBSTSubtree(node.left);
        LBSTPair rp = largestBSTSubtree(node.right);

        int min = Math.min(Math.min(lp.min, rp.min), node.data);
        int max = Math.max(Math.max(lp.max, rp.max), node.data);
        boolean isBST = (lp.isBST == true) && (rp.isBST == true) &&
            ((lp.max < node.data) && (node.data < rp.min));

        Node lbstnode = null; //largest bst subtree node
        int size = 0; //largest bst subtree size

        if (isBST == true) {
            //the subtree rooted at node is a bst
            lbstnode = node;
            size = lp.size + rp.size + 1;
        } 
        else {
            if(lp.size > rp.size) {
                lbstnode = lp.node;
                size = lp.size;
            } 
            else {
                lbstnode = rp.node;
                size = rp.size;
            }
        }

        return new LBSTPair(min, max, isBST, lbstnode, size);

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        LBSTPair res = largestBSTSubtree(root);
        System.out.println(res.node.data + "@" + res.size);
    }

}