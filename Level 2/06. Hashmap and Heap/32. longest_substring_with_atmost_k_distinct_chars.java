//https://www.lintcode.com/problem/386/

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap < Character, Integer > map = new HashMap < > ();
        int olen = 0;

        int i = -1;
        int j = -1;

        while (i < s.length() - 1) {
            //aquire
            while (i < s.length() - 1) {
                i++;

                char ch = s.charAt(i);
                int nf = map.getOrDefault(ch, 0) + 1;
                map.put(ch, nf);

                if (map.size() <= k) {
                    //ans updation
                    int len = i - j;
                    olen = Math.max(olen, len);
                } 
                else {
                    break;
                }
            }

            //release
            while (j < i) {
                j++;

                char ch = s.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                    break;
                } 
                else {
                    int nf = map.get(ch) - 1;
                    map.put(ch, nf);
                }
            }
        }

        return olen;
    }
}