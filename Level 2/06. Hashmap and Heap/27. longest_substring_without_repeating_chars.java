class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        int i = -1; //aquire
        int j = -1; //release
        
        int olen = 0;
        
        while(i < s.length()-1) {
            //aquire
            while(i < s.length()-1) {
                i++;
                
                char ch = s.charAt(i);
                int nf = map.getOrDefault(ch,0) + 1;
                map.put(ch,nf);
                
                if(nf == 2) {
                    //invalid
                    break;
                }
                else {
                    //valid
                    int len = i - j; //ans -> j+1 to i
                    olen = Math.max(olen,len);
                }
            }
            
            //release -> to be valid again
            while(j < i) {
                j++;
                
                char ch = s.charAt(j);
               
                if(map.get(ch) == 1) {
                    map.remove(ch);
                }
                else {
                    map.put(ch,1);
                    //you are valid again
                    break;
                }
            }
        }
        
        return olen;
    }
}