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

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode tail = headA;
        
        //to find tail
        while(tail.next != null) {
            tail = tail.next;
        }
        
        tail.next = headB; //may be cycle creation
        
        ListNode slow = headA;
        ListNode fast = headA;
        boolean isCycle = false;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        
        if(isCycle == false) {
            //lists are not intersected
            tail.next = null;
            return null;
        }
        
    
        //to find intersection point
        slow = headA;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        tail.next = null;
        return slow;
    }

    // Input_code===================================================

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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}