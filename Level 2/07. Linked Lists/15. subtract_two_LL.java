import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static int size(ListNode head) {
        int s = 0;
        ListNode temp = head;

        while (temp != null) {
            s++;
            temp = temp.next;
        }

        return s;
    }

    public static ListNode greater(ListNode l1, ListNode l2) {
        int s1 = size(l1);
        int s2 = size(l2);

        if (s1 > s2) {
            return l1;
        } else if (s2 > s1) {
            return l2;
        }


        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val > c2.val) {
                return l1;
            } else if (c1.val < c2.val) {
                return l2;
            } else {
                c1 = c1.next;
                c2 = c2.next;
            }
        }

        if (c1 == null && c2 == null) {
            return null;
        } else if (c1 == null) {
            return l2;
        } else {
            return l1;
        }
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode itr = dh;

        ListNode c1 = null;
        ListNode c2 = null;

        if (greater(l1, l2) == l1) {
            //l1 represented number is greater
            c1 = reverse(l1);
            c2 = reverse(l2);
        } else if (greater(l1, l2) == l2) {
            //l2 represented number is greater
            c1 = reverse(l2);
            c2 = reverse(l1);
        } else {
            //both numbebers are equal
            return new ListNode(0);
        }


        int borrow = 0;

        while (c1 != null) {
            int sub = (c1.val + borrow);

            if (c2 != null) {
                sub -= c2.val;
                c2 = c2.next;
            }

            if (sub < 0) {
                sub += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }


            ListNode nn = new ListNode(sub);
            itr.next = nn;
            itr = itr.next;
            c1 = c1.next;
        }


        ListNode ansptr = reverse(dh.next);
        ListNode temp = ansptr;

        while (temp != null && temp.val == 0) {
            temp = temp.next;
        }

        return temp;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }

}