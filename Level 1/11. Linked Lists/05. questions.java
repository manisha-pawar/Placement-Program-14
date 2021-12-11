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

        //functions
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

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
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
    }




    //segregate odd even nodes
    public void oddEven() {
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();


        while (this.size != 0) {

            Node temp = this.head;
            this.removeFirst();

            if (temp.data % 2 == 0) {
                //temp.data is even
                even.addLast(temp.data);
            } else {
                //temp.data is odd
                odd.addLast(temp.data);
            }

        }

        if (odd.size != 0 && even.size != 0) {
            //both odd and even are present
            odd.tail.next = even.head;

            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if (odd.size != 0) {
            //only odd is present
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else if (even.size != 0) {
            //only even is present
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }

    }




    //intersection point of two linked lists
    public static int findIntersection(LinkedList one, LinkedList two) {

        int l1 = one.size;
        int l2 = two.size;

        int gap = 0;

        Node p1 = null; //p1 will point to longer ll
        Node p2 = null; //p2 will point to shorted ll

        if (l1 > l2) {
            p1 = one.head;
            p2 = two.head;
            gap = l1 - l2;
        } else {
            p1 = two.head;
            p2 = one.head;
            gap = l2 - l1;
        }

        //travel longer ll gap times
        while (gap-- > 0) {
            p1 = p1.next;
        }

        //travel simultaneously in both ll
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null) {
            //no intersection point
            return -1;
        } else {
            return p1.data;
        }

    }




    //remove duplicates from sorted linked list
    public void removeDuplicates() {
        LinkedList ans = new LinkedList();

        while (this.size != 0) {
            int data = this.head.data;
            this.removeFirst();

            if (ans.size == 0 || ans.tail.data != data) {
                ans.addLast(data);
            }
        }

        this.head = ans.head;
        this.tail = ans.tail;
        this.size = ans.size;
    }




    //k reverse
    public void kReverse(int k) {
        LinkedList ans = new LinkedList(); //to store overall ans

        while (this.size >= k) {
            LinkedList curr = new LinkedList();

            //work on a single group of k nodes
            for (int i = 0; i < k; i++) {
                int data = this.head.data;
                this.removeFirst();
                curr.addFirst(data);
            }

            //settle curr in overall ans
            if (ans.size == 0) {
                //no connection required
                ans.head = curr.head;
                ans.tail = curr.tail;
                ans.size = curr.size;
            } else {
                //connection required
                ans.tail.next = curr.head;
                ans.tail = curr.tail;
                ans.size += curr.size;
            }
        }

        while (this.size != 0) {
            int data = this.head.data;
            this.removeFirst();
            ans.addLast(data);
        }


        this.head = ans.head;
        this.tail = ans.tail;
        this.size = ans.size;

    }




    //fold a linked list
    Node ln;
    public void fold() {
        // write your code here
        ln = head;
        fold_helper(head, 0);
    }

    private void fold_helper(Node rn, int lev) {
        if (rn == null) {
            return;
        }

        fold_helper(rn.next, lev + 1);

        if (lev > size / 2) {
            //work
            Node temp = ln.next;
            ln.next = rn;
            rn.next = temp;
            ln = temp;
        } else if (lev == size / 2) {
            //set tail
            tail = rn;
            tail.next = null;
        } else {
            //do nothing
        }
    }




    //add two linked lists
    private static int add_helper(Node p1, int pv1, Node p2, int pv2, LinkedList ans) {
        if (p1 == null && p2 == null) {
            return 0;
        }

        int sum = 0;
        if (pv1 > pv2) {
            //move forward in first list
            int c = add_helper(p1.next, pv1 - 1, p2, pv2, ans);
            sum = c + p1.data;
        } else if (pv1 < pv2) {
            //move forward in second list
            int c = add_helper(p1, pv1, p2.next, pv2 - 1, ans);
            sum = c + p2.data;
        } else {
            //move forward in both lists
            int c = add_helper(p1.next, pv1 - 1, p2.next, pv2 - 1, ans);
            sum = c + p1.data + p2.data;
        }

        int val = sum % 10;
        int nc = sum / 10;

        ans.addFirst(val);
        return nc;

    }
    
    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList ans = new LinkedList();
        int c = add_helper(one.head, one.size - 1, two.head, two.size - 1, ans);
        if (c == 1) {
            ans.addFirst(c);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }
}