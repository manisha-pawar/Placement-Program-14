import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable < Pair > {
        int ln; //list number
        int i; //index number
        int val; //val

        Pair(int ln, int i, int val) {
            this.ln = ln;
            this.i = i;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }


    }
    public static ArrayList < Integer > mergeKSortedLists(ArrayList < ArrayList < Integer >> lists) {
        ArrayList < Integer > ml = new ArrayList < > ();
        PriorityQueue < Pair > pq = new PriorityQueue < > ();

        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }


        while (pq.size() > 0) {
            Pair rem = pq.remove();
            ml.add(rem.val);

            int ln = rem.ln;
            int i = rem.i + 1;

            if (i < lists.get(ln).size()) {
                Pair p = new Pair(ln, i, lists.get(ln).get(i));
                pq.add(p);
            }
        }

        return ml;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList < ArrayList < Integer >> lists = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ArrayList < Integer > list = new ArrayList < > ();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList < Integer > mlist = mergeKSortedLists(lists);
        for (int val: mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}