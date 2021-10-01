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

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }



        //merge two sorted linked lists
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();

            Node p1 = l1.head;
            Node p2 = l2.head;

            while (p1 != null && p2 != null) {
                if (p1.data < p2.data) {
                    ml.addLast(p1.data);
                    p1 = p1.next;
                } else {
                    ml.addLast(p2.data);
                    p2 = p2.next;
                }
            }

            while (p1 != null) {
                ml.addLast(p1.data);
                p1 = p1.next;
            }

            while (p2 != null) {
                ml.addLast(p2.data);
                p2 = p2.next;
            }

            return ml;
        }



        //merge sort
        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList bl = new LinkedList();
                bl.addLast(head.data);
                return bl;
            }

            Node mid = midNode(head, tail);

            LinkedList left = mergeSort(head, mid);
            LinkedList right = mergeSort(mid.next, tail);

            LinkedList ans = mergeTwoSortedLists(left, right);
            return ans;
        }


        //customised mid-node
        public static Node midNode(Node head, Node tail) {
            Node slow = head;
            Node fast = head;

            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;

        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        sorted.display();
        l1.display();
    }
}