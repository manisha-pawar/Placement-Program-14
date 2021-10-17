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




    //size of generic tree
    public static int size(Node node) {
        int size = 0;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            int cfs = size(child);

            size += cfs;
        }

        return size + 1;
    }



    //max of generic tree
    public static int max(Node node) {
        int max = node.data;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int cfm = max(child);

            if (cfm > max) {
                max = cfm;
            }
        }

        return max;
    }



    //height of generic tree
    public static int height(Node node) {

        int cbht = -1; //height is required in terms of edges

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int ht = height(child);

            if (ht > cbht) {
                cbht = ht;
            }
        }

        return cbht + 1;

    }




    //traversals
    public static void traversals(Node node) {
        //node pre
        System.out.println("Node Pre " + node.data);

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            //edge pre
            System.out.println("Edge Pre " + node.data + "--" + child.data);

            //edge (call)
            traversals(child);

            //edge post
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        //node post
        System.out.println("Node Post " + node.data);
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}