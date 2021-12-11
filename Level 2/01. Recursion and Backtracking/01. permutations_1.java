import java.io.*;
import java.util.*;

public class Main {

    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        //boxes - options
        for (int b = 0; b < boxes.length; b++) {
            if (boxes[b] == 0) {
                boxes[b] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[b] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }

}