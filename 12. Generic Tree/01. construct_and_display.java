import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList < Node > children;

        Node() {

        }

        Node(int data) {
            this.data = data;
            children = new ArrayList < > ();
        }
    }

    public static Node construct(int[] arr) {
        Stack < Node > st = new Stack < > ();

        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node nn = new Node(arr[i]);

                if (st.size() == 0) {
                    //nn is the root node
                    root = nn;
                } else {
                    Node par = st.peek();
                    par.children.add(nn);
                }

                st.push(nn);
            }
        }

        return root;
    }

    public static void display(Node node) {
        //self task
        System.out.print(node.data + " -> ");
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            System.out.print(child.data + ", ");
        }
        System.out.println(".");

        //faith
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            display(child);
        }
    }

    public static void main(String[] args) {
        int[]arr = {10,20,50,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(arr);

        display(root);
    }
}