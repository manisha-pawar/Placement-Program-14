import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int n, int row, int col, String asf) {
        if (col == n) {
            row++;
            col = 0;
            asf = asf + "\n";
        }

        if (row == n) {
            if (qpsf == n) {
                System.out.println(asf);
            }
            return;
        }


        queensCombinations(qpsf + 1, n, row, col + 1, asf + "q");
        queensCombinations(qpsf, n, row, col + 1, asf + "-");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}