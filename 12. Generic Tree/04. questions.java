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



    //17th oct

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



    //21st oct

    //distance between two nodes
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        //lca -> p1.get(i+1) or p2.get(j+1)

        int v1 = (i + 1) - 0; //distance between lca and first node
        int v2 = (j + 1) - 0; //distance between lca and second node

        return v1 + v2;
    }



    //linearize - T : O(n^2)
    public static void linearize(Node node) {

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            linearize(child);
        }


        while (node.children.size() > 1) {
            int s = node.children.size();
            Node lc = node.children.get(s - 1);
            Node slc = node.children.get(s - 2);

            Node tail = getTail(slc);

            node.children.remove(s - 1);
            tail.children.add(lc);
        }

    }

    public static Node getTail(Node node) {

        while (node.children.size() == 1) {
            node = node.children.get(0);
        }

        return node;
    }




    //linearize - T : O(n)
    public static Node linearize(Node node) {
        if (node.children.size() == 0) {
            return node;
        }

        Node lc = node.children.get(node.children.size() - 1);
        Node tail = linearize(lc);

        while (node.children.size() > 1) {
            int s = node.children.size();
            Node slc = node.children.get(s - 2);

            Node slct = linearize(slc); //second last child's tail

            node.children.remove(s - 1);
            slct.children.add(lc);

            lc = slc;
        }

        return tail;
    }



    //are trees similar in shape
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if (areSimilar(c1, c2) == false) {
                return false;
            }
        }


        return true;

    }



    //are trees mirror in shape
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - i - 1);

            if (areMirror(c1, c2) == false) {
                return false;
            }
        }

        return true;
    }



    //is tree symmetric
    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }


    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}