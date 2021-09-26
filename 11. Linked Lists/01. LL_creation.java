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


        //add functions
        void addLast(int val) {
            Node nn = new Node();
            nn.data = val;

            if (size == 0) {
                head = tail = nn;
            } else {
                tail.next = nn;
                tail = nn;
            }

            size++;
        }

        public void addFirst(int val) {
            Node nn = new Node();
            nn.data = val;

            if (size == 0) {
                head = tail = nn;
            } else {
                nn.next = head;
                head = nn;
            }

            size++;

        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node im1n = getNodeAt(idx - 1); //(idx-1)'s node
                Node in = im1n.next; //idx node

                //insert new node between im1n and in
                Node nn = new Node();
                nn.data = val;

                im1n.next = nn;
                nn.next = in ;

                size++;
            }
        }


        //display
        public void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }



        //get functions
        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            }

            Node n = getNodeAt(idx);
            return n.data;
        }

        private Node getNodeAt(int idx) {
            int ci = 0;
            Node temp = head;

            while (temp != null && ci < idx) {
                temp = temp.next;
                ci++;
            }
            return temp;
        }



        //remove functions
        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            }

            if (size == 1) {
                head = tail = null;
            } else {
                Node hn = head.next;
                head.next = null;
                head = hn;
            }
            size--;
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            }

            if (size == 1) {
                head = tail = null;
            } else {
                Node sln = getNodeAt(size - 2);
                sln.next = null;
                tail = sln;
            }
            size--;

        }

        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node im1n = getNodeAt(idx - 1); //(idx-1)'s node
                Node in = im1n.next; //idx's node

                //in order to skip idx's node
                im1n.next = in .next; in .next = null;

                size--;
            }
        }
    }


    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println(list.size);

        if (list.size > 0) {
            System.out.println(list.tail.data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            str = br.readLine();
        }

        testList(list);
    }
}