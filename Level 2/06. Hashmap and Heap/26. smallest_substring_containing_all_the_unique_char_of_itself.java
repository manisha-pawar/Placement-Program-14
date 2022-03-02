import java.util.*;

public class Main {

    public static int solution(String s) {
        int olen = Integer.MAX_VALUE;

        HashSet < Character > hs = new HashSet < > ();
        HashMap < Character, Integer > map = new HashMap < > ();

        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }

        int i = -1;
        int j = -1;

        while (i < s.length() - 1) {
            while (i < s.length() - 1 && map.size() < hs.size()) {
                i++;

                char ch = s.charAt(i);
                int nf = map.getOrDefault(ch, 0) + 1;

                map.put(ch, nf);
            }

            while (j < i && map.size() == hs.size()) {
                //ans
                int len = i - j;

                if (len < olen) {
                    olen = len;
                }

                j++;

                char ch = s.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    int nf = map.get(ch) - 1;
                    map.put(ch, nf);
                }
            }
        }

        return olen;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}