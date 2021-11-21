import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList < Integer > data;
        boolean isMinHeap;

        public PriorityQueue(boolean isMinHeap) {
            data = new ArrayList < > ();
            this.isMinHeap = isMinHeap;
        }

        //-ve -> priority(v1) > priority(v2)
        //+ve -> priority(v1) < priority(v2)

        private int compare(int v1, int v2) {
            if (isMinHeap == true) {
                //smaller value has higher priority
                return v1 - v2;
            } else {
                //larger value has higher priority
                return v2 - v1;
            }
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

            if (compare(data.get(ci), data.get(pi)) < 0) {
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

            if (lci < data.size() && compare(data.get(lci), data.get(mpi)) < 0) {
                mpi = lci;
            }
            if (rci < data.size() && compare(data.get(rci), data.get(mpi)) < 0) {
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

        PriorityQueue pq = new PriorityQueue(false);
        pq.add(10);
        pq.add(8);
        pq.add(15);
        pq.add(20);
        pq.add(5);

        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }


    }
}