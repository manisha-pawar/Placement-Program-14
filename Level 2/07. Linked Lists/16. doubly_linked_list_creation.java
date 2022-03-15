import java.util.*;

class Main {

    public static class DoublyLinkedList {
        private class Node {
            int data = 0;
            Node prev = null;
            Node next = null;

            Node(int data) {
                this.data = data;
            }

        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curr = this.head;
            sb.append("[");
            while (curr != null) {
                sb.append(curr.data);
                if (curr.next != null)
                    sb.append(", ");
                curr = curr.next;
            }
            sb.append("]");

            return sb.toString();
        }

        //exceptions
        private boolean ListIsEmptyException() {
            if (this.size == 0) {
                System.out.print("ListIsEmpty: ");
                return true;
            }
            return false;
        }

        private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
            if (index < leftRange || index > rightRange) {
                System.out.print("IndexIsInValid: ");
                return true;
            }
            return false;
        }


        //Doubly linked list utility functions
        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }


        //add First in DLL
        public void addFirst(int val) {
            Node nn = new Node(val);

            if (size == 0) {
                //this is first addition
                head = tail = nn;
            } else {
                nn.next = head;
                head.prev = nn;
                head = nn;
            }
            size++;
        }


        //add last in DLL
        public void addLast(int val) {
            Node nn = new Node(val);
            if (size == 0) {
                head = tail = nn;
            } else {
                tail.next = nn;
                nn.prev = tail;
                tail = nn;
            }
            size++;
        }


        //remove first in DLL
        public int removeFirst() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            }

            int data = head.data;
            if (size == 1) {
                head = tail = null;
            } else {
                Node hn = head.next;
                head.next = null;
                hn.prev = null;
                head = hn;
            }
            size--;
            return data;
        }


        //remove last in DLL
        public int removeLast() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            }

            int data = tail.data;
            if (size == 1) {
                head = tail = null;
            } else {
                Node tp = tail.prev;
                tp.next = null;
                tail.prev = null;
                tail = tp;
            }
            size--;
            return data;
        }


        //get first and get last in DLL
        public int getFirst() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            } else {
                return tail.data;
            }
        }



        private Node getNodeAt(int idx) {
            if (idx == 0) {
                return head;
            } else if (idx == size - 1) {
                return tail;
            }

            Node temp = head;

            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }

            return temp;
        }


        //get at in DLL
        public int getAt(int index) {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            } else if (indexIsInvalidException(index, 0, size - 1) == true) {
                return -1;
            } else {
                Node node = getNodeAt(index);
                return node.data;
            }
        }


        //add at in DLL
        public void addAt(int index, int data) {
            if (indexIsInvalidException(index, 0, size) == true) {
                System.out.println("-1");
                return;
            }

            //index  = [0,size]
            if (index == 0) {
                addFirst(data);
            } else if (index == size) {
                addLast(data);
            } else {
                //index = [1,size-1]
                Node curr = getNodeAt(index); //idx node
                Node cp = curr.prev; //idx-1 node

                Node nn = new Node(data);
                cp.next = nn;
                nn.prev = cp;
                nn.next = curr;
                curr.prev = nn;

                size++;
            }
        }


        //remove at in DLL
        public int removeAt(int index) {
            if (ListIsEmptyException() == true) {
                return -1;
            } else if (indexIsInvalidException(index, 0, size - 1) == true) {
                return -1;
            }

            //index -> [0,size-1]

            if (index == 0) {
                return removeFirst();
            } else if (index == size - 1) {
                return removeLast();
            } else {
                //index -> [1,size-2]
                Node cn = getNodeAt(index);
                Node pn = cn.prev;
                Node fn = cn.next;

                pn.next = fn;
                fn.prev = pn;
                cn.next = cn.prev = null;

                size--;
                return cn.data;
            }
        }


        //add before in DLL
        public void addBefore(Node refNode, int data) {
            if (refNode == head) {
                addFirst(data);
            } else {
                Node nn = new Node(data);
                Node rfnp = refNode.prev; //reference node prev'

                rfnp.next = nn;
                nn.prev = rfnp;
                nn.next = refNode;
                refNode.prev = nn;

                size++;
            }
        }


        //add after in DLL
        public void addAfter(Node refNode, int data) {
            if (refNode == tail) {
                addLast(data);
            } else {
                Node nn = new Node(data);
                Node refnf = refNode.next; //ref node's forward

                refNode.next = nn;
                nn.prev = refNode;
                nn.next = refnf;
                refnf.prev = nn;

                size++;
            }

        }


        //remove before in DLL
        public int removeBefore(Node refNode) {
            if (refNode == head) {
                //do nothing
                System.out.print("LocationIsInvalid: ");
                return -1;
            } else if (refNode == head.next) {
                //we have to do removeFirst()
                return removeFirst();
            } else {
                Node cn = refNode.prev; //node to be removed
                Node pn = cn.prev;

                pn.next = refNode;
                refNode.prev = pn;
                cn.next = cn.prev = null;

                size--;
                return cn.data;
            }
        }


        //remove after in DLL
        public int removeAfter(Node refNode) {
            if (refNode == tail) {
                System.out.println("LocationIsInvalid: ");
                return -1;
            } else if (refNode == tail.prev) {
                return removeLast();
            } else {
                Node cn = refNode.next; //node to be removed
                Node fn = cn.next;

                refNode.next = fn;
                fn.prev = refNode;
                cn.next = cn.prev = null;

                size--;
                return cn.data;
            }
        }

        public void addBefore(int idx, int data) {
            Node node = getNodeAt(idx);
            addBefore(node, data);
        }
        public void addAfter(int idx, int data) {
            Node node = getNodeAt(idx);
            addAfter(node, data);
        }

        public int removeBefore(int idx) {
            Node node = getNodeAt(idx);
            return removeBefore(node);
        }

        public int removeAfter(int idx) {
            Node node = getNodeAt(idx);
            return removeAfter(node);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        String str = scn.nextLine();
        while (!str.equals("stop")) {
            String[] s = str.split(" ");
            if (s[0].equals("addFirst"))
                dll.addFirst(Integer.parseInt(s[1]));

            str = scn.nextLine();
        }
        System.out.println(dll);
    }
}