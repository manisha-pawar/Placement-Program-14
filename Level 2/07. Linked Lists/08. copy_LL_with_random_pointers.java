/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


//with using hashmap
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>map = new HashMap<>();
    
        //copy val & next
        Node temp = head;
        Node dh = new Node(-1);
        Node dt = dh;
        
        while(temp != null) {
            Node nn = new Node(temp.val);
            dt.next = nn;
            
            map.put(temp,nn); //old node vs new node
            dt = dt.next;
            temp = temp.next;
        }
        
        
        //set random ptr in copied LL
        Node t1 = head;
        Node t2 = dh.next;
        
        while(t1 != null) {
            t2.random = t1.random == null ? null : map.get(t1.random);
            
            t1 = t1.next;
            t2 = t2.next;
        }
        
        return dh.next;
    }  
}



//without using hashmap
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        //insert copied nodes between original nodes
        Node temp = head;
        
        while(temp != null) {
            Node tn = temp.next;
            Node nn = new Node(temp.val);
            
            temp.next = nn;
            nn.next = tn;
            
            temp = tn;
        }
        
        
        //set random ptr
        Node curr = head;
        
        while(curr != null) {
            curr.next.random = 
            curr.random == null ? null : curr.random.next;

            curr = curr.next.next;
        }
        
        
        //segregate the original and copied LL
        Node c1 = head;
        Node ans = c1.next;
        Node c2 = c1.next;
        
        while(c1 != null && c2 != null) {
            Node n1 = c2.next;
            Node n2 = n1 == null ? null : n1.next;
            
            c1.next = n1;
            c2.next = n2;
            
            c1 = n1;
            c2 = n2;
        }
        
        return ans;
        
    }
     
}