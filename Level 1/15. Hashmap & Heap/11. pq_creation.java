import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList < Integer > data;

        public PriorityQueue() {
            data = new ArrayList < > ();
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int ci) {
            if (ci == 0) {
                return;
            }

            int pi = (ci - 1) / 2;

            if (data.get(ci) < data.get(pi)) {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            int vi = data.get(i);
            int vj = data.get(j);

            data.set(i, vj);
            data.set(j, vi);
        }

        public int remove() {
            if (size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                swap(0, data.size() - 1);
                int ele = data.remove(data.size() - 1);
                downheapify(0);

                return ele;
            }
        }

        private void downheapify(int pi) {
            int lci = 2 * pi + 1;
            int rci = lci + 1;

            int mpi = pi; //most priority index

            if (lci < data.size() && data.get(lci) < data.get(mpi)) {
                mpi = lci;
            }
            if (rci < data.size() && data.get(rci) < data.get(mpi)) {
                mpi = rci;
            }


            if (pi != mpi) {
                swap(pi, mpi);
                downheapify(mpi);
            }
        }

        public int peek() {
            if (size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                return data.get(0);
            }
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}