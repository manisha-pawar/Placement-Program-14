import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        System.out.println(islands(arr));
    }


    public static int islands(int[][] arr) {
        int count = 0;
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] vis = new boolean[n][m];

        //0 -> land, 1 -> water
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && vis[i][j] == false) {
                    travel(arr, i, j, vis);
                    count++;
                }
            }
        }

        return count;
    }


    public static void travel(int[][] arr, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || vis[i][j] == true) {
            return;
        }

        vis[i][j] = true;

        travel(arr, i - 1, j, vis); //top
        travel(arr, i, j - 1, vis); //left
        travel(arr, i + 1, j, vis); //down
        travel(arr, i, j + 1, vis); //right
    }

}