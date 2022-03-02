//smallest substring of a string containing all the characters of another string

class Solution {
    public String minWindow(String s, String t) {        
        int mtc = 0;
        HashMap<Character,Integer>sm = new HashMap<>(); //for current window
        HashMap<Character,Integer>tm = new HashMap<>(); //for 't' string
        
        for(int i=0; i < t.length();i++) {
            char ch = t.charAt(i);
            int nf = tm.getOrDefault(ch,0) + 1;
            tm.put(ch,nf);
        }
        
        int as = -1;
        int ae = -1;
        int olen = Integer.MAX_VALUE;
        int i = -1; //aquiring
        int j = -1; //release
        
        while(i < s.length()-1) {
            //aquire 
            while(i < s.length()-1 && mtc < t.length()) {
                i++;
                
                //aquire ith char 
                char ch = s.charAt(i);
                
                int nf = sm.getOrDefault(ch,0) + 1;
                sm.put(ch,nf);
                
                //impact on mtc
                if(sm.get(ch) <= tm.getOrDefault(ch,0)) {
                    mtc++;
                }
            }
            
            //release
            while(j < i && mtc == t.length()) {
                //ans -> j+1 to i
                
                int len = i-j;
                if(len < olen) {
                    as = j+1;
                    ae = i;
                    olen = len;
                }
                
                j++;
                
                //release jth char
                char ch = s.charAt(j);
                if(sm.get(ch) == 1) {
                    sm.remove(ch);
                }
                else {
                    int nf = sm.get(ch) - 1;
                    sm.put(ch,nf);
                }
                
                //impact on match count
                if(sm.getOrDefault(ch,0) < tm.getOrDefault(ch,0)) {
                    mtc--;
                }
            }
        }
        
        if(as == -1 && ae == -1) {
            return "";
        }
        
        return s.substring(as,ae+1);
    }
}