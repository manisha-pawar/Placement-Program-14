import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int n, int row, int col, String asf, boolean[] queens) {
        if (col == n) {
            row++;
            col = 0;
            asf = asf + "\n";
        }

        if (row == n) {
            if (qpsf == n) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }

        //yes calls
        for (int q = 0; q < n; q++) {
            if (queens[q] == false) {
                queens[q] = true;
                queensPermutations(qpsf + 1, n, row, col + 1, asf + "q" + (q + 1) + "\t", queens);
                queens[q] = false;
            }
        }

        //no call
        queensPermutations(qpsf, n, row, col + 1, asf + "-\t", queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}