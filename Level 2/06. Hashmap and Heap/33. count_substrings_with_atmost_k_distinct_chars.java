import java.util.*;

public class Main {

    public static int solution(String str, int k) {
        // write your code here
        HashMap < Character, Integer > map = new HashMap < > ();
        int count = 0;

        int i = -1;
        int j = -1;

        while (i < str.length() - 1) {
            //aquire
            while (i < str.length() - 1) {
                i++;

                char ch = str.charAt(i);
                int nf = map.getOrDefault(ch, 0) + 1;
                map.put(ch, nf);

                if (map.size() <= k) {
                    //ans updation
                    count += (i - j);
                } 
                else {
                    break;
                }
            }

            //release
            while (j < i && map.size() > k) {
                j++;

                char ch = str.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                    //valid again
                    count += (i - j);
                } 
                else {
                    int nf = map.get(ch) - 1;
                    map.put(ch, nf);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }

}