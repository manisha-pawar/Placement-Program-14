import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        
        int t1id = scn.nextInt(); //source tower
        int t2id = scn.nextInt(); //dest tower
        int t3id = scn.nextInt(); //helper
        
        //task -> to move n disks from t1->t2 using t3
        toh(n,t1id,t2id,t3id);
        
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n == 0) {
            return;
        }
        
        //move n-1 disks from t1->t3
        toh(n-1,t1id,t3id,t2id);
        
        //move nth disk from t1->t2
        System.out.println(n + "[" + t1id +" -> " + t2id + "]");
        
        //move n-1 disks from t3->t2
        toh(n-1,t3id,t2id,t1id);
    }

}