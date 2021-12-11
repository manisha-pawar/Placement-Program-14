import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long ans = arrangeBuildings(n);

        System.out.println(ans);
    }

    public static long arrangeBuildings(int n) {

        int ocs = 1; //old count space
        int ocb = 1; //old count building

        for (int i = 2; i <= n; i++) {
            int ncs = ocs + ocb; //new count space
            int ncb = ocs; //new count building

            ocs = ncs;
            ocb = ncb;
        }

        int osw = ocs + ocb; //one side ways

        long ans = ((long)(osw) * osw);
        return ans;


    }

}