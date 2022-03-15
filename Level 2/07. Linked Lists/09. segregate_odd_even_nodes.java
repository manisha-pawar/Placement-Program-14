import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode oh = new ListNode(-1);
        ListNode ot = oh;
        
        ListNode eh = new ListNode(-1);
        ListNode et = eh;
        
        ListNode temp = head;
        
        while(temp != null) {
            if(temp.val % 2 == 0) {
                et.next = temp;
                et = et.next;
            }
            else {
                ot.next = temp;
                ot = ot.next;
            }
            temp = temp.next;
        }
        
        ot.next = null;
        
        et.next = oh.next;
        
        return eh.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}