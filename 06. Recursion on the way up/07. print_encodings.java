import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn+.next();
        
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        
        
        if(str.charAt(0) == '0') {
            return;
        }
        
        char ch0 = str.charAt(0); //'5'
        
        char mchs = (char)((ch0 - '0') + 'a' - 1); //mapping character 'e'
        
        //single call
        String ros1 = str.substring(1);
        printEncodings(ros1, asf + mchs);
        
        if(str.length() >= 2) {
            //double call
            char ch1 = str.charAt(1);
            int u = ch1 - '0';
            int t = ch0 - '0';
            
            int val = t*10 + u;
            
            if(val <= 26) {
                String ros2 = str.substring(2);
                char mchp =  (char)(val + 'a' - 1);
                
                printEncodings(ros2,asf + mchp);
            }
        }
        
    }

}