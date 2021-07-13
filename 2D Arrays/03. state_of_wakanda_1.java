import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        colTraversal(mat);
    }

    public static void colTraversal(int[][] mat) {

        for (int c = 0; c < mat[0].length; c++) {
            if (c % 2 == 0) {
                //c is an even col -> travel top to bottom
                for (int r = 0; r < mat.length; r++) {
                    System.out.println(mat[r][c]);
                }
            } else {
                //c is a odd col -> travel bottom to top
                for (int r = mat.length - 1; r >= 0; r--) {
                    System.out.println(mat[r][c]);
                }
            }
        }
    }

}