import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int n, boolean[][] chess, int li, int lj) {
        if (qpsf == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == true) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = li; i < n; i++) {
            for (int j = (i == li) ? lj + 1 : 0; j < n; j++) {
                chess[i][j] = true;
                queensCombinations(qpsf + 1, n, chess, i, j);
                chess[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, 0, -1);
    }
}