import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r1 = scn.nextInt();
        int c1 = scn.nextInt();

        int[][] A = new int[r1][c1];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = scn.nextInt();
            }
        }

        int r2 = scn.nextInt();
        int c2 = scn.nextInt();

        int[][] B = new int[r2][c2];

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = scn.nextInt();
            }
        }

        if (c1 != r2) {
            System.out.println("Invalid input");
        } else {
            matrixMult(A, B);
        }
    }


    public static void matrixMult(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;

        int[][] res = new int[r1][c2];

        //to select ith row of A
        for (int i = 0; i < r1; i++) {
            //to select jth col of B
            for (int j = 0; j < c2; j++) {
                //one on one mapping of A's ith row & B's jth col
                int val = 0;
                for (int k = 0; k < c1; k++) {
                    val += A[i][k] * B[k][j];
                }
                res[i][j] = val;
            }
        }


        //print resultant matrix
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}