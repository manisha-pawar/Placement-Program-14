import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str  = scn.nextLine();
        
        System.out.println(balanced_brackets(str));
    }
    
    public static boolean balanced_brackets(String exp) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < exp.length();i++ ) {
            char ch = exp.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else if(ch == ')' || ch == ']' || ch == '}') {
                //validate
                if(ch == ')') {
                    if(st.size() == 0 || st.peek() != '(') {
                        return false;
                    }
                }
                else if(ch == ']') {
                    if(st.size() == 0 || st.peek() != '[') {
                        return false;
                    }
                }
                else if(ch == '}') {
                    if(st.size() == 0 || st.peek() != '{') {
                        return false;
                    }
                }
                
                st.pop(); //to pop opening bracket
            }
        }
        
        if(st.size() > 0) {
            //extra opening brackets
            return false;
        }
        else {
            return true;
        }
    } 

}