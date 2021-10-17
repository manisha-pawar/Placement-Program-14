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




    //normal level order
    public static void levelOrder(Node node) {
        ArrayDeque < Node > q = new ArrayDeque < > ();

        q.add(node);

        while (q.size() != 0) {
            //remove
            Node rem = q.remove();

            //work
            System.out.print(rem.data + " ");

            //add children
            for (int i = 0; i < rem.children.size(); i++) {
                Node child = rem.children.get(i);
                q.add(child);
            }
        }

        System.out.println(".");
    }




    //level order line wise - using two queues
    public static void levelOrderLinewise(Node node) {

        ArrayDeque < Node > mQ = new ArrayDeque < > ();
        ArrayDeque < Node > cQ = new ArrayDeque < > ();

        mQ.add(node);

        while (mQ.size() > 0) {
            //remove
            Node rem = mQ.remove();

            //work
            System.out.print(rem.data + " ");

            //add children
            for (int i = 0; i < rem.children.size(); i++) {
                Node child = rem.children.get(i);
                cQ.add(child);
            }


            if (mQ.size() == 0) {
                System.out.println();
                mQ = cQ;
                cQ = new ArrayDeque < > ();
            }
        }
    }


    //level order linewise - count method
    public static void levelOrderLinewise(Node node) {
        ArrayDeque < Node > q = new ArrayDeque < > ();

        q.add(node);

        while (q.size() > 0) {
            int count = q.size();

            for (int k = 0; k < count; k++) {
                //remove
                Node rem = q.remove();

                //work
                System.out.print(rem.data + " ");

                //add children
                for (int i = 0; i < rem.children.size(); i++) {
                    Node child = rem.children.get(i);
                    q.add(child);
                }
            }

            System.out.println();

        }
    }




    //level order linewise zigzag - way 1
    public static void levelOrderLinewiseZZ(Node node) {
        ArrayDeque < Node > q = new ArrayDeque < > ();
        int lev = 0;

        q.add(node);

        while (q.size() > 0) {
            int count = q.size();

            ArrayList < Integer > list = new ArrayList < > ();
            for (int k = 0; k < count; k++) {
                //remove
                Node rem = q.remove();

                //work
                list.add(rem.data);

                //add children
                for (int i = 0; i < rem.children.size(); i++) {
                    Node child = rem.children.get(i);
                    q.add(child);
                }
            }

            if (lev % 2 == 0) {
                //level is even -> L to R
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            } else {
                //level is odd -> R to L
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }

            lev++;

        }
    }


    //level order linewise zigzag - way2 (using two stacks)
    public static void levelOrderLinewiseZZ(Node node) {
        Stack < Node > ms = new Stack < > ();
        Stack < Node > cs = new Stack < > ();

        int lev = 0;

        ms.push(node);

        while (ms.size() > 0) {
            //remove
            Node rem = ms.pop();

            //work
            System.out.print(rem.data + " ");


            //add children
            if (lev % 2 == 0) {
                for (int i = 0; i < rem.children.size(); i++) {
                    Node child = rem.children.get(i);
                    cs.push(child);
                }
            } else {
                for (int i = rem.children.size() - 1; i >= 0; i--) {
                    Node child = rem.children.get(i);
                    cs.push(child);
                }
            }


            if (ms.size() == 0) {
                System.out.println();
                ms = cs;
                cs = new Stack < > ();
                lev++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }

}