import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        conversion(exp);
    }

    public static int priority(char opr) {
        if (opr == '+' || opr == '-') {
            return 1;
        } else if (opr == '*' || opr == '/') {
            return 2;
        } else {
            return -1;
        }
    }
    public static void conversion(String exp) {
        //exp is an infix expression

        Stack < Character > oprst = new Stack < > ();
        Stack < String > pre = new Stack < > ();
        Stack < String > post = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                oprst.push(ch);
            } 
            else if (ch == ')') {
                //evaluate till an opening 

                while (oprst.peek() != '(') {
                    char opr = oprst.pop();

                    //work in pre stack
                    String prerv = pre.pop(); //pre right value
                    String prelv = pre.pop(); //pre left value

                    String prev = opr + prelv + prerv; //pre value
                    pre.push(prev);

                    //work in post stack
                    String porv = post.pop(); //post right value
                    String polv = post.pop(); //post left value

                    String pov = polv + porv + opr; //post value
                    post.push(pov);
                }
                oprst.pop();
            } 
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + ""); //char to string
                post.push(ch + "");
            } 
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (oprst.size() > 0 && oprst.peek() != '(' && priority(oprst.peek()) >= priority(ch)) {
                    //evaluate
                    char opr = oprst.pop();

                    //work in pre stack
                    String prerv = pre.pop();
                    String prelv = pre.pop();

                    String prev = opr + prelv + prerv;
                    pre.push(prev);

                    //work in post stack
                    String porv = post.pop();
                    String polv = post.pop();

                    String pov = polv + porv + opr;
                    post.push(pov);
                }

                oprst.push(ch);
            }
        }

        while (oprst.size() > 0) {
            char opr = oprst.pop();

            //work in pre stack
            String prerv = pre.pop();
            String prelv = pre.pop();

            String prev = opr + prelv + prerv;
            pre.push(prev);

            //work in post stack
            String porv = post.pop();
            String polv = post.pop();

            String pov = polv + porv + opr;
            post.push(pov);
        }


        System.out.println(post.peek());
        System.out.println(pre.peek());


    }
}