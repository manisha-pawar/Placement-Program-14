//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();
        
        if(s.length() < p.length()) {
            return ans;
        }
        
        HashMap<Character,Integer>pm = new HashMap<>(); //pattern map
        HashMap<Character,Integer>wm = new HashMap<>(); //window map
        
        //creating pattern map
        for(int i=0; i < p.length();i++) {
            char ch = p.charAt(i);
            int nf = pm.getOrDefault(ch,0) + 1;
            pm.put(ch,nf);
        }
        
        int i = 0;
        int j = 0;
        
        //creating the first window
        for(;i < p.length();i++) {
            char ch = s.charAt(i);
            int nf = wm.getOrDefault(ch,0) + 1;
            wm.put(ch,nf);
        }
        
        while(i < s.length()) {
            //window -> j to i-1
            if(areMapsEqual(pm,wm) == true) {
                ans.add(j);
            }
            
            //in order to go to the next window aquire ith char & release jth char
            char ch1 = s.charAt(i);
            int nf1 = wm.getOrDefault(ch1,0) + 1;
            wm.put(ch1,nf1);
            
            char ch2 = s.charAt(j);
            if(wm.get(ch2) == 1) {
                wm.remove(ch2);
            }
            else {
                int nf2 = wm.get(ch2) - 1;
                wm.put(ch2,nf2);
            }
            
            i++;
            j++;
        }
        
        if(areMapsEqual(pm,wm) == true) {
            ans.add(j);
        }
        
        return ans;
    }
    
    public boolean areMapsEqual(HashMap<Character,Integer>map1, HashMap<Character,Integer>map2) {
        if(map1.size() != map2.size()) {
            return false;
        }
        
        for(char key : map1.keySet()) {
            if(map2.containsKey(key) == false) {
                return false;
            }
            
            int v1 = map1.get(key);
            int v2 = map2.get(key);
            
            if(v1 != v2) {
                return false;
            }
        }
        
        return true;
    }
    
    
    
}