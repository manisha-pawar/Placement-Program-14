import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap < String, String > map = new HashMap < > ();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }


        HashMap < String, Boolean > sp = new HashMap < > ();

        for (String src: map.keySet()) {
            String dest = map.get(src);

            sp.put(src, sp.getOrDefault(src, true));
            sp.put(dest, false);
        }

        String city = "";

        //starting point
        for (String src: sp.keySet()) {
            if (sp.get(src) == true) {
                city = src;
                break;
            }
        }


        while (map.containsKey(city) == true) {
            System.out.print(city + " -> ");
            city = map.get(city);
        }

        System.out.println(city + ".");



    }
}