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



    //node with maximum subtree sum
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


    public static void main(String[] args) throws Exception {
        //input can be managed
        //before calling a function which uses static variables, always refresh the static variables
    }

}