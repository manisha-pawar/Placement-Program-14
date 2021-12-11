import java.util.Stack;

public class Main {

    //next greater element on right (index based)
    public static void main(String[] args) {
        int[] arr = {10,6,9,17,5,4,11};

        int n = arr.length;
        Stack < Integer > st = new Stack < > ();
        int[] nge = new int[n];

        nge[n - 1] = -1;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek() - i;
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nge[i] + " ");
        }

    }
}