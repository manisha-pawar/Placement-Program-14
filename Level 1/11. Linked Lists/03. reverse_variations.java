import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }


        private Node getNodeAt(int pos) {
            int ci = 0;
            Node temp = head;

            while (temp != null && ci < pos) {
                ci++;
                temp = temp.next;
            }

            return temp;
        }



        //reverse a linked list data iterative
        public void reverseDI() {
            Node ln = head;
            int li = 0;
            int ri = size - 1;

            while (li < ri) {
                Node rn = getNodeAt(ri);

                //swap ln & rn data's
                int ld = ln.data;
                int rd = rn.data;
                ln.data = rd;
                rn.data = ld;

                ln = ln.next;
                li++;
                ri--;
            }

        }



        //reverse a linked list pointer iterative
        public void reversePI() {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                //backup
                Node next = curr.next;

                //connection revert
                curr.next = prev;

                //move
                prev = curr;
                curr = next;
            }

            //swap head and tail
            Node temp = head;
            head = tail;
            tail = temp;
        }



        //reverse a linked list data recursive - method 1
        Node ln;
        public void reverseDR() {
            ln = head;
            reverseDRH(head, 0);
        }

        private void reverseDRH(Node rn, int lev) {
            if (rn == null) {
                return;
            }

            reverseDRH(rn.next, lev + 1);

            if (lev >= (size / 2)) {
                //swap
                int ld = ln.data;
                int rd = rn.data;
                ln.data = rd;
                rn.data = ld;

                ln = ln.next; //heap change (this.ln = this.ln.next)
            }
        }



        //reverse a linked list data recursive - method 2
        public void reverseDR() {
            reverseDRH(head, 0);
        }

        private Node reverseDRH(Node rn, int lev) {
            if (rn == null) {
                return head;
            }

            Node ln = reverseDRH(rn.next, lev + 1);

            if (lev >= size / 2) {
                int ld = ln.data;
                int rd = rn.data;
                ln.data = rd;
                rn.data = ld;
            }

            return ln.next;
        }




        //reverse a linked list pointer recursive
        private void reversePRHelper(Node prev) {
            if (prev.next == null) {
                return;
            }

            reversePRHelper(prev.next);

            Node curr = prev.next;
            curr.next = prev;
        }

        public void reversePR() {
            // write your code here
            reversePRHelper(head);
            head.next = null;

            //swap head & tail
            Node temp = head;
            head = tail;
            tail = temp;
        }




        //display reverse
        private void displayReverseHelper(Node node) {
            if (node == null) {
                return;
            }

            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }

        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }


    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }
}