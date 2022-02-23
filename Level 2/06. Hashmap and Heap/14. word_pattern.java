class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>map = new HashMap<>();
        HashSet<String>hs = new HashSet<>();
        
        String[]words = s.split(" ");
        
        if(pattern.length() != words.length) {
            return false;
        }
        
        for(int i=0; i < pattern.length();i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if(map.containsKey(ch) == false) {
                if(hs.contains(word) == true) {
                    //word is already mapped with a different char
                    return false;
                }
                map.put(ch,word);
                hs.add(word);
            }
            else {
                if(map.get(ch).equals(word) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
}