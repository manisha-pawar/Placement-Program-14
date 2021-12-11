import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        prefix_eval_and_conversions(exp);
    }


    public static int calculate(int v1, int v2, char opr) {
        if (opr == '+') {
            return v1 + v2;
        } else if (opr == '-') {
            return v1 - v2;
        } else if (opr == '*') {
            return v1 * v2;
        } else if (opr == '/') {
            return v1 / v2;
        } else {
            return -1;
        }
    }
    public static void prefix_eval_and_conversions(String exp) {
        //exp is a prefix expression

        Stack < Integer > valst = new Stack < > ();
        Stack < String > infix = new Stack < > ();
        Stack < String > postfix = new Stack < > ();

        for (int i = exp.length() - 1; i >= 0; i--) {

            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                //ch is an operand
                valst.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
                //ch is an operator

                //evaluate
                char opr = ch;

                //work in value stack
                int lv = valst.pop();
                int rv = valst.pop();

                int val = calculate(lv, rv, opr);
                valst.push(val);

                //work in infix stack
                String inlv = infix.pop();
                String inrv = infix.pop();

                String inval = "(" + inlv + opr + inrv + ")";
                infix.push(inval);

                //work in prefix stack
                String postlv = postfix.pop();
                String postrv = postfix.pop();

                String postval = postlv + postrv + opr;
                postfix.push(postval);

            }
        }


        System.out.println(valst.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }
}