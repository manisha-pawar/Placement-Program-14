import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        System.out.println(count_encodings(str));
    }
    
    public static int count_encodings(String str) {
        str = "." + str;
        
        int[]dp = new int[str.length()];
        
        dp[0] = 1;
        
        if(str.charAt(1) != '0') {
            dp[1] = 1;
        }
        else {
            return 0;
        }
        
        
        for(int i=2; i < dp.length;i++) {
            char p = str.charAt(i-1);
            char c = str.charAt(i);
            
            if(c == '0' && p == '0') {
                //c and p both are '0'
                dp[i] = 0;
            }
            else if(c == '0') {
                //only c is '0'
                if(p == '1' || p == '2') {
                    dp[i] = dp[i-2];
                }
            }
            else if(p == '0') {
                //only p is '0'
                dp[i] = dp[i-1];
            }
            else {
                //c and p both are non-zero
                dp[i] = dp[i-1];
                
                int num = Integer.parseInt(p + "" + c);
                
                if(num <= 26) {
                    dp[i] += dp[i-2];
                }
            }
            
        }
        
        return dp[dp.length-1];
    }
}