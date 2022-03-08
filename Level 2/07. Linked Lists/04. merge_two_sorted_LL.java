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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        ListNode t1 = list1;
        ListNode t2 = list2;
        
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
}