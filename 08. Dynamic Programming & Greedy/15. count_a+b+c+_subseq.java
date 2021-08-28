import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        System.out.println(count(str));
    }
    
    public static int count(String str) {
        int a = 0; //count of a+
        int ab = 0; //count of a+b+
        int abc = 0; //count of a+b+c+
        
        for(int i=0; i < str.length();i++) {
            char ch = str.charAt(i);
            
            if(ch == 'a') {
                a = 2*a + 1;
            }
            else if(ch == 'b') {
                ab = 2*ab + a;
            }
            else if(ch == 'c') {
                abc = 2*abc + ab;
            }
        }
        
        return abc;
    }
}