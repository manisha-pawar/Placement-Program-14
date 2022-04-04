public class AVL {
    static class Node {
        int data;
        Node left;
        Node right;
        int ht = 0;
        int bf = 0;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void updateHtAndBal(Node node) {
        int lh = node.left != null ? node.left.ht : -1;
        int rh = node.right != null ? node.right.ht : -1;

        node.ht = Math.max(lh,rh) + 1;
        node.bf = lh - rh;
    }

    public static Node add(Node node,int data) {
        if(node == null) {
            return new Node(data);
        }

        if(node.data < data) {
            node.right = add(node.right,data);
        }
        else if(node.data > data) {
            node.left = add(node.left,data);
        } 
        else {
            //do nothing
        }

        updateHtAndBal(node);

        if(node.bf < -1 || node.bf > 1) {
            return work(node);
        }

        return node;
    }

    public static int max(Node node) {
        if(node.right != null) {
            return max(node.right);
        }
        else {
            return node.data;
        }
    }

    public static Node remove(Node node, int data) {
        if (node == null) {
            //data is not present in tree
            return null;
        }

        if (node.data < data) {
            node.right = remove(node.right, data);
        } 
        else if (node.data > data) {
            node.left = remove(node.left, data);
        }
        else {
            //no child
            if (node.left == null && node.right == null) {
                return null;
            }
            //single child
            else if (node.left == null) {
                //node has only one child - right child
                return node.right;
            } 
            else if (node.right == null) {
                //node has only one child - left child
                return node.left;
            }
            //both childs
            else {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            }
        }

        updateHtAndBal(node);

        if(node.bf < -1 || node.bf > 1) {
            return work(node);
        }

        return node;
    }

    public static Node work(Node node) {
        if(node.bf == 2) {
            if(node.left.bf == 1) {
                //LL
                return solveLL(node);
            }
            else {
                //LR
                node.left = solveRR(node.left);
                return solveLL(node);
            }
        }
        else {
            if(node.right.bf == -1) {
                //RR
                return solveRR(node);
            }
            else {
                //RL
                node.right = solveLL(node.right);
                return solveRR(node);
            }
        }
    }

    public static Node solveLL(Node A) {
        //in order to solve LL problem at A, we need to do right rotation at A's left child

        Node B = A.left;
        Node B_right = B.right;
        B.right = A;
        A.left = B_right;

        updateHtAndBal(A);
        updateHtAndBal(B);

        return B;
    }

    public static Node solveRR(Node A) {
        //in order to solve RR problem at A, we need to do left rotation at A's right child

        Node B = A.right;
        Node B_left = B.left;
        B.left = A;
        A.right = B_left;

        updateHtAndBal(A);
        updateHtAndBal(B);

        return B;
    }

    public static void display(Node node) {
        if(node == null) {
            return;
        }
        
        String mp = " <- " + node.data + " -> ";
        String lp = (node.left == null) ? "." : (node.left.data + "");
        String rp = (node.right == null) ? "." : (node.right.data + "");
        
        System.out.println(lp + mp + rp);
        
        display(node.left);
        display(node.right);
    }


    public static void main(String[]args) {
        int[]arr = {10,20,30,40,50,60,70,80,72};

        Node root = null;

        for(int i=0; i < arr.length;i++) {
            root = add(root,arr[i]);
        } 

        root = remove(root,40);
        root = remove(root,50);
        
        display(root);
    }
}