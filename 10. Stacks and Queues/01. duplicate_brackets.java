import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        System.out.println(duplicateBrackets(str));
    }
    
    public static boolean duplicateBrackets(String exp) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < exp.length();i++) {
            char ch = exp.charAt(i);
            
            if(ch == ')') {
                //settle
                int count = 0;
                
                while(st.peek() != '(') {
                    count++;
                    st.pop();
                }
                
                //this pair of bracket is redundant
                if(count == 0) {
                    return true;
                }
                
                st.pop(); //for '(' bracket
            }
            else if(ch != ' ') {
                //'(',operand,operators
                st.push(ch);
            }
        }
        
        return false;
    }

}