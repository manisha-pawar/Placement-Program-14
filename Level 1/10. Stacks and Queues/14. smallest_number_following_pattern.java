import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        solution(str);
    }

    public static void solution(String str) {
        Stack < Integer > st = new Stack < > ();
        int c = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);


            if (ch == 'd') {
                c++;
                st.push(c);
            } else if (ch == 'i') {
                c++;
                st.push(c);

                //print the stack
                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }

        c++;
        st.push(c);

        //print the stack
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}