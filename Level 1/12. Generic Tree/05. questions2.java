import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }



    //23rd oct

    //multisolver
    static int size;
    static int max;
    static int min;
    static int ht;

    public static void multisolver(Node node, int lev) {
        //self work
        size++;
        max = Math.max(max, node.data);
        min = Math.min(min, node.data);
        ht = Math.max(ht, lev);

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            multisolver(child, lev + 1);
        }
    }




    //predecessor and successor
    static Node predecessor;
    static Node successor;
    static Node prev;
    static Node curr;

    public static void predecessorAndSuccessor(Node node, int data) {
        prev = curr;
        curr = node;

        if (curr.data == data) {
            predecessor = prev;
        } else if (prev != null && prev.data == data) {
            successor = curr;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            predecessorAndSuccessor(child, data);
        }
    }



    //ceil and floor
    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {

        //ceil -> qualified min
        if (node.data > data && ceil > node.data) {
            ceil = node.data;
        }

        //floor -> qualified max
        if (node.data < data && floor < node.data) {
            floor = node.data;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            ceilAndFloor(child, data);
        }
    }



    //kth largest
    public static int kthLargest(Node node, int k) {
        int key = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            floor = Integer.MIN_VALUE;
            ceilAndFloor(node, key);
            key = floor;
        }

        return floor;
    }



    //node with maximum subtree sum - using static variables
    static Node mssn;
    static int mss;

    public static void maxSubtreeSum(Node root) {
        mssn = null; //max subtree sum node
        mss = Integer.MIN_VALUE; //max subtree sum
        sum(root);

        System.out.println(mssn.data + "@" + mss);
    }

    public static int sum(Node node) {
        int sum = node.data;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int cfs = sum(child);

            sum += cfs;
        }

        if (sum > mss) {
            mss = sum;
            mssn = node;
        }

        return sum;
    }



    //node with max subtree sum - using pair return type
    public static class Pair {
        int sum;
        int mss; //max subtree sum
        Node mssn; //max subtree sum node

        Pair() {

        }

        Pair(int sum, int mss, Node mssn) {
            this.sum = sum;
            this.mss = mss;
            this.mssn = mssn;
        }
    }

    public static Pair maxSubtreeSum(Node node) {
        int sum = node.data;
        int mss = Integer.MIN_VALUE;
        Node mssn = null;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            Pair cp = maxSubtreeSum(child);

            sum += cp.sum;

            if (cp.mss > mss) {
                mss = cp.mss;
                mssn = cp.mssn;
            }
        }


        //node's contendor (subtree rooted at node)
        if (sum > mss) {
            mss = sum;
            mssn = node;
        }

        return new Pair(sum, mss, mssn);
    }




    //diameter of generic tree
    static int dia;
    public static void diameter(Node root) {
        dia = 0;
        height(root);
        System.out.println(dia);
    }

    public static int height(Node node) {
        int bcht = -1; //best child height
        int sbcht = -1; //second best child height

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int cht = height(child);

            if (cht > bcht) {
                sbcht = bcht;
                bcht = cht;
            } else if (cht > sbcht) {
                sbcht = cht;
            }
        }

        int dist = bcht + sbcht + 2; //node's contendor

        if (dist > dia) {
            dia = dist;
        }

        return bcht + 1;
    }




    //iterative preorder and postorder
    public static void IterativePreandPostOrder(Node root) {
        String pre = "";
        String post = "";

        Stack < Pair > st = new Stack < > ();
        Pair rp = new Pair(root, -1);
        st.push(rp);


        while (st.size() > 0) {
            Pair top = st.peek();
            Node node = top.node;
            int state = top.state;

            if (state == -1) {
                //pre area
                pre += (node.data + " ");
                top.state++;
            } else if (state < node.children.size()) {
                Node child = node.children.get(state);
                st.push(new Pair(child, -1));
                top.state++;
            } else if (state == node.children.size()) {
                //post
                post += (node.data + " ");
                st.pop();
            }
        }

        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
        //before calling a function which uses static variables, always refresh the static variables
    }

}