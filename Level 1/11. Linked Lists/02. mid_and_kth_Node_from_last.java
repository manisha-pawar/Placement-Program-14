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



        //mid of the linked list
        public int mid() {
            Node slow = head;
            Node fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }



        //kth node from the end
        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;

            //1. move fast by k steps
            int temp = k;
            while (fast != null && temp > 0) {
                fast = fast.next;
                temp--;
            }

            if (fast == null && temp >= 0) {
                //k >= size
                return -1;
            }

            //2. move slow and fast by same speed(1x)
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }
}