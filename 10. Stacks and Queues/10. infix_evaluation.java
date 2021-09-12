import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        int ans = infix_eval(exp);
        System.out.println(ans);
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

    public static int infix_eval(String exp) {
        Stack < Integer > valst = new Stack < > (); //value stack -> operands
        Stack < Character > oprst = new Stack < > (); //operator stack


        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                //operand, push in value st
                valst.push(ch - '0');
            } else if (ch == '(') {
                //push in operator st
                oprst.push(ch);
            } else if (ch == ')') {
                //evaluate till and opening bracket occurs
                while (oprst.peek() != '(') {
                    //evaluate
                    int rv = valst.pop();
                    int lv = valst.pop();

                    char opr = oprst.pop(); //operation
                    int val = calculate(lv, rv, opr);

                    valst.push(val);

                }

                oprst.pop(); //opening bracket
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //operator
                while (oprst.size() > 0 && oprst.peek() != '(' && priority(oprst.peek()) >= priority(ch)) {
                    //evaluate
                    int rv = valst.pop();
                    int lv = valst.pop();

                    char opr = oprst.pop(); //operation
                    int val = calculate(lv, rv, opr);

                    valst.push(val);
                }

                oprst.push(ch);
            }
        }

        while (oprst.size() > 0) {
            //evaluate
            int rv = valst.pop();
            int lv = valst.pop();

            char opr = oprst.pop(); //operation
            int val = calculate(lv, rv, opr);

            valst.push(val);
        }

        return valst.peek();

    }
}