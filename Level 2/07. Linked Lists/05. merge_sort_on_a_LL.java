/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode mergeTwoSortedLL(ListNode head1,ListNode head2) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        ListNode t1 = head1;
        ListNode t2 = head2;
        
        while(t1 != null && t2 != null) {
            if(t1.val <= t2.val) {
                dt.next = t1;
                t1 = t1.next;
            }
            else {
                dt.next = t2;
                t2 = t2.next;
            }
            dt = dt.next;
        }
        
        if(t1 != null) {
            dt.next = t1;
        }
        else if(t2 != null) {
            dt.next = t2;
        }
        
        return dh.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            //there is only one node
            return head;
        }
        
        ListNode mid = mid(head);
        ListNode sh = mid.next;
        mid.next = null;
        
        ListNode lh = sortList(head);
        ListNode rh = sortList(sh);
        
        return mergeTwoSortedLL(lh,rh);
        
    }
}