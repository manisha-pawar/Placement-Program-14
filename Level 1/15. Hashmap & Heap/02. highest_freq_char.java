import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        char hfc = highestFreqChar(str);
        System.out.println(hfc);
    }

    public static char highestFreqChar(String str) {
        HashMap < Character, Integer > map = new HashMap < > ();

        //build freq map
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch) == false) {
                map.put(ch, 1);
            } else {
                int nf = map.get(ch) + 1;
                map.put(ch, nf);
            }
        }

        //find out the hfc
        char hfc = '\0';
        int hf = Integer.MIN_VALUE;


        // for(char key : map.keySet())  {
        //     int val = map.get(key);

        //     if(val > hf) {
        //         hfc = key;
        //         hf = val;
        //     }
        // }

        ArrayList < Character > keys = new ArrayList < > (map.keySet());

        for (int i = 0; i < keys.size(); i++) {
            char key = keys.get(i);

            int val = map.get(key);

            if (val > hf) {
                hfc = key;
                hf = val;
            }
        }

        return hfc;
    }


}