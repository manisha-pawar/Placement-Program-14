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




    //1. tilt of tree using static variable
    static int tilt = 0;
    public static int tilt(Node node) {
        tilt = 0; //tile of binary tree

        sum(node);

        return tilt;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int ls = sum(node.left); //left subtree sum
        int rs = sum(node.right); //right subtree sum

        int tilt_node = Math.abs(ls - rs); //tilt of a node

        tilt += tilt_node;

        return ls + rs + node.data;
    }




    //2. tilt of tree using pair return type
    static class TPair {
        int ss; //subtree sum
        int tilt; //subtree tilt

        TPair(int ss, int tilt) {
            this.ss = ss;
            this.tilt = tilt;
        }
    }


    public static TPair tilt(Node node) {
        if (node == null) {
            return new TPair(0, 0);
        }

        TPair lp = tilt(node.left);
        TPair rp = tilt(node.right);

        int ss = lp.ss + rp.ss + node.data;
        int tilt_node = Math.abs(lp.ss - rp.ss);
        int tilt = lp.tilt + rp.tilt + tilt_node; //subtree tilt

        return new TPair(ss, tilt);
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}