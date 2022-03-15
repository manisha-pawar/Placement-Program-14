class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node() {
            
        }
        
        Node(int key,int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    
    //DLL
    Node head = null;
    Node tail = null;
    int size = 0;
    
    //HashMap
    HashMap<Integer,Node>map;

    int cap = 0;
    
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key) == true) {
            Node n = map.get(key);

            //make 'n' most recent
            removeNode(n);
            addLastNode(n);

            return n.value;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) == true) {
            Node n = map.get(key);
            n.value = value;

            //make 'n' most recent
            removeNode(n);
            addLastNode(n);
        }
        else {
            Node n = new Node(key,value);
            addLastNode(n);
            map.put(key,n);

            if(size > cap) {
                //remove least recent node
                int rk = head.key;
                removeFirst();
                map.remove(rk);
            }
        }
    }


    private void removeFirst() {
        if(size == 0) {
            return;
        }

        if(size == 1) {
            head = tail = null;
        }
        else {
            Node hn = head.next;
            head.next = null;
            hn.prev = null;
            head = hn;
        }

        size--;
    }

    private void removeLast() {
        if(size == 0) {
            return;
        }

        if(size == 1) {
            head = tail = null;
        }
        else {
            Node tp = tail.prev;
            tp.next = null;
            tail.prev = null;
            tail = tp;
        }

        size--;
    }


    private void addLastNode(Node nn) {
        if(size == 0) {
            head = tail = nn;
        }
        else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }

        size++;
    }

    private void removeNode(Node c) {
        if(size == 0) {
            return;
        }
        else if(c == head) {
            removeFirst();
        }
        else if(c == tail) {
            removeLast();
        }
        else {
            Node p = c.prev;
            Node n = c.next;

            p.next = n;
            n.prev = p;

            c.next = c.prev = null;

            size--;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */