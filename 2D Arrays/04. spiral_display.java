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

        spiralDisplay(mat);
    }

    public static void spiralDisplay(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int tne = n * m; //total number of elements
        int psf = 0; //elements printed so far

        int rs = 0;
        int cs = 0;
        int re = n - 1;
        int ce = m - 1;

        while (psf < tne) {
            //left wall
            for (int r = rs; r <= re && psf < tne; r++) {
                System.out.println(mat[r][cs]);
                psf++;
            }
            cs++;

            //bottom wall
            for (int c = cs; c <= ce && psf < tne; c++) {
                System.out.println(mat[re][c]);
                psf++;
            }
            re--;

            //right wall
            for (int r = re; r >= rs && psf < tne; r--) {
                System.out.println(mat[r][ce]);
                psf++;
            }
            ce--;


            //top wall
            for (int c = ce; c >= cs && psf < tne; c--) {
                System.out.println(mat[rs][c]);
                psf++;
            }
            rs++;
        }
    }

}