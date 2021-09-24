import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static class Interval implements Comparable < Interval > {
        int st;
        int et;

        Interval() {

        }

        Interval(int st, int et) {
            this.st = st;
            this.et = et;
        }

        //this > o -> +ve
        //this < o -> -ve
        //this == o -> 0 return
        
        public int compareTo(Interval o) {
            if (this.st < o.st) {
                return -1;
            } else if (this.st > o.st) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void mergeOverlappingIntervals(int[][] a) {
        // merge overlapping intervals and print in increasing order of start time

        Interval[] arr = new Interval[a.length];

        for (int i = 0; i < a.length; i++) {
            Interval intvl = new Interval(a[i][0], a[i][1]);
            arr[i] = intvl;
        }

        Arrays.sort(arr);


        Stack < Interval > st = new Stack < > ();
        st.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (st.peek().et >= arr[i].st) {
                //merging is possible
                st.peek().et = Math.max(st.peek().et, arr[i].et);
            } else {
                //merging is not possible
                st.push(arr[i]);
            }
        }

        //print the ans
        Stack < Interval > rst = new Stack < > ();

        while (st.size() > 0) {
            rst.push(st.pop());
        }

        while (rst.size() > 0) {
            Interval top = rst.pop();
            System.out.println(top.st + " " + top.et);
        }
    }

}