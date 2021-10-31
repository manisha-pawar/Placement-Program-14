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

        Node(int data) {
            this.data = data;
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



    //transform to left cloned tree from normal tree
    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }

        Node ln = createLeftCloneTree(node.left); //left subtree root after cloning
        Node rn = createLeftCloneTree(node.right); //right subtree root after cloning

        node.right = rn;
        Node cn = new Node(node.data); //cloned
        node.left = cn;
        cn.left = ln;

        return node;
    }



    //transform to normal tree from left cloned tree
    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        node.left = transBackFromLeftClonedTree(node.left.left);
        node.right = transBackFromLeftClonedTree(node.right);

        return node;
    }


    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}