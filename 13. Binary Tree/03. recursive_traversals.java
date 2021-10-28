import java.util.*;

public class Main{
    
    public static class Node {
        int data;
        Node left;
        Node right;
        
        Node() {
            
        }
        
        Node(int data) {
            this.data  = data;
        }
    }
    
    public static class Pair {
        Node node;
        int st;
        
        Pair() {
            
        }
        
        Pair(Node node,int st) {
            this.node = node;
            this.st = st;
        }
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
    
    public static Node construct(int[]arr) {
        Node root = new Node(arr[0]);
        Pair rp = new Pair(root,0);
        
        
        //0 -> waiting for lc
        //1 -> waiting for rc
        //2 -> done and pop
    
        Stack<Pair>st = new Stack<>();
        st.push(rp);
        int idx = 1;
        
        while(st.size() > 0) {
            Pair top = st.peek();
            if(top.st == 0) {
                //top's node is waiting lc
                if(arr[idx] == -1) {
                    top.node.left = null;
                }
                else {
                    Node node = new Node(arr[idx]);
                    top.node.left = node;
                    Pair lcp = new Pair(node,0);
                    st.push(lcp);
                }
                top.st++;
                idx++;
                
            }
            else if(top.st == 1){
                //top's node is waiting rc
                if(arr[idx] == -1) {
                    top.node.right = null;
                }
                else {
                    Node node = new Node(arr[idx]);
                    top.node.right = node;
                    Pair rcp = new Pair(node,0);
                    st.push(rcp);
                }
                top.st++;
                idx++;
            }
            else {
                //top's node is done
                st.pop();
            }
        }
        
        return root;
       
    }
    

    //pre-order
    public static void preorder(Node node) {
        if(node == null) {
            return;
        }
        
        //pre 
        System.out.println(node.data);
        
        preorder(node.left);
        preorder(node.right);
    }
    


    //post-order
    public static void postorder(Node node) {
        if(node == null) {
            return;
        }
        
        postorder(node.left);
        postorder(node.right);
        
        //post 
        System.out.println(node.data);
    }
    
    

    //in-order
    public static void inorder(Node node) {
        if(node == null) {
            return;
        }
        
        inorder(node.left);
        
        //in
        System.out.println(node.data);
        
        inorder(node.right);
    }
    
    
    public static void main(String[]args) {
        int[]arr = {10,20,40,-1,-1,50,80,-1,-1,-1,30,60,-1,90,-1,-1,70,-1,-1};
        Node root = construct(arr);
        
        // display(root);
        inorder(root);
    }
}