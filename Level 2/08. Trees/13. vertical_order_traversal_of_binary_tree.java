import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int x;
        
        Pair() {
            
        }
        
        Pair(TreeNode node,int x) {
            this.node = node;
            this.x = x;
        }
    }
    
    static int sx;
    static int lx;
    
    public static void helper(TreeNode node,int x) {
        if(node == null) {
            return;
        }
        
        sx = Math.min(sx,x);
        lx = Math.max(lx,x);
        
        helper(node.left,x-1);
        helper(node.right,x+1);
    }
    
    

    //VOT using hashmap
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        helper(root,0);
        
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        q.add(new Pair(root,0));
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            ArrayList<Integer>list = map.getOrDefault(rem.x,new ArrayList<>());
            list.add(rem.node.val);
            map.put(rem.x,list);
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.x - 1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.x + 1));
            }
        }
        
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        
        //vln is equivalent to x
        for(int vln=sx; vln <= lx;vln++) {
            ans.add(map.get(vln));
        }
        
        return ans;

    }



    //VOT without using hashmap
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        helper(root,0);
        
        int w = lx - sx + 1;
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        
        for(int i=0; i < w;i++) {
            ans.add(new ArrayList<>());
        }
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        q.add(new Pair(root,-sx)); //origin shifting
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            ans.get(rem.x).add(rem.node.val);
            
            //add children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left,rem.x-1));
            }
            if(rem.node.right != null) {
                q.add(new Pair(rem.node.right,rem.x+1));
            }
        }
        t
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}