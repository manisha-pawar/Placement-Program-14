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
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        ListNode mid = mid(head);
        ListNode sh = mid.next;
        mid.next = null;
        
        ListNode t1 = head;
        ListNode t2 = reverse(sh);
        
        boolean flag = true;
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        while(t1 != null || t2 != null) {
            if(flag == true) {
                dt.next = t1;
                t1 = t1.next;
            }
            else {
                dt.next = t2;
                t2 = t2.next;
            }
            
            flag = !flag;
            dt = dt.next;
        }
        
    }
    
}