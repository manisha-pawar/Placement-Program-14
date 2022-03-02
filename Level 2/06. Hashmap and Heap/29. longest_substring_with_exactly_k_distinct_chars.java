class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap < Character, Integer > map = new HashMap < > ();
        int olen = -1;
        int i = -1;
        int j = -1;

        while (i < s.length() - 1) {
            //aquire
            while (i < s.length() - 1 && map.size() <= k) {
                i++;

                char ch = s.charAt(i);
                int nf = map.getOrDefault(ch, 0) + 1;
                map.put(ch, nf);

                if (map.size() == k) {
                    //ans update
                    int len = i - j;
                    olen = Math.max(olen, len);
                }
            }

            //release
            while (j < i && map.size() > k) {
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

}