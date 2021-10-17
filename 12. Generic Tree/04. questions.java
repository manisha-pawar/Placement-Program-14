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




    //mirror of generic tree
    public static void mirror(Node node) {

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            mirror(child);
        }

        //reverse node's children arraylist
        int l = 0;
        int r = node.children.size() - 1;

        while (l < r) {
            Node ln = node.children.get(l);
            Node rn = node.children.get(r);

            node.children.set(l, rn);
            node.children.set(r, ln);

            l++;
            r--;
        }
    }




    //remove leaves
    public static void removeLeaves(Node node) {

        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);

            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            removeLeaves(child);
        }

    }




    //find
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            boolean fic = find(child, data);

            if (fic == true) {
                return true;
            }
        }

        return false;
    }




    //node to root path
    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList < Integer > list = new ArrayList < > ();
            list.add(data);
            return list;
        }

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);

            ArrayList < Integer > n2cp = nodeToRootPath(child, data);

            if (n2cp.size() > 0) {
                n2cp.add(node.data); //converting n2cp(node to child path) to n2rp(node to root path)
                return n2cp;
            }
        }

        return new ArrayList < > ();

    }



    //lowest common ancestor
    public static int lca(Node node, int d1, int d2) {

        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        return p1.get(i + 1);
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}