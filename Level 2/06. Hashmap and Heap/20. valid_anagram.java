class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character,Integer>map = new HashMap<>();
        
        //build map using 's'
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            int nf = map.getOrDefault(ch,0) + 1;
            map.put(ch,nf);
        }
        
        //destroy map using 't' 
        for(int i=0; i < t.length();i++) {
            char ch = t.charAt(i);
            int nf = map.getOrDefault(ch,0) - 1;
            map.put(ch,nf);
        }
        
        //is map empty
        for(char key : map.keySet()) {
            if(map.get(key) != 0) {
                return false;
            }
        }
        
        return true;

    }
}