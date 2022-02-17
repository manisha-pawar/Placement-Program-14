public class Solution {
   
    public int calculate(String s) {
        Stack < Integer > vs = new Stack < > ();
        Stack < Character > os = new Stack < > ();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch) == true) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)) == true) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                vs.push(val);
                i--;
            } 
            else if (ch == '(') {
                os.push(ch);
            } 
            else if (ch == ')') {
                while (os.size() > 0 && os.peek() != '(') {
                    int b = vs.pop();
                    int a = vs.pop();
                    char opr = os.pop();
                    vs.push(evaluate(a, b, opr));
                }
                os.pop();
            } 
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (os.size() > 0 && os.peek() != '(' && priority(os.peek()) >= priority(ch)) {
                    int b = vs.pop();
                    int a = vs.pop();
                    char opr = os.pop();
                    vs.push(evaluate(a, b, opr));
                }
                os.push(ch);
            }
        }

        while (os.size() > 0) {
            int b = vs.pop();
            int a = vs.pop();
            char opr = os.pop();
            vs.push(evaluate(a, b, opr));
        }

        return vs.peek();
    }

    public int evaluate(int a, int b, char opr) {
        if (opr == '+') {
            return a + b;
        } else if (opr == '-') {
            return a - b;
        } else if (opr == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    public int priority(char opr) {
        if (opr == '+' || opr == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}