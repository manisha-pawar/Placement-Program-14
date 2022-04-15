public class Solution {
    /**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */

    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here

        HashMap<String,HashSet<String>>map = new HashMap<>();

        //to build to the HashMap
        for(int i=0; i < pairs.size();i++) {
            String word1 = pairs.get(i).get(0);
            String word2 = pairs.get(i).get(1);

            //word1 as key
            HashSet<String>hs1 = map.getOrDefault(word1,new HashSet<>());
            hs1.add(word2);
            map.put(word1,hs1);

            //word2 as key
            HashSet<String>hs2 = map.getOrDefault(word2,new HashSet<>());
            hs2.add(word1);
            map.put(word2,hs2);
        }


        //verificiation
        if(words1.length != words2.length) {
            return false;
        }

        for(int i=0; i < words1.length;i++) {
            String word1 = words1[i];
            String word2 = words2[i];

            if(word1.equals(word2) == true) {
                continue;
            }
            else if(map.containsKey(word1) == false || map.containsKey(word2) == false) {
                return false;
            }
            else if(map.get(word1).contains(word2) == false){
                return false;
            }
        }

        return true;
    }
}