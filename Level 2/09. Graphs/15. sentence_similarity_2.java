public class Solution {
    /**
     * @param words1: 
     * @param words2: 
     * @param pairs: 
     * @return: Whether sentences are similary or not?
     */

    HashMap<String,String>parent;
    HashMap<String,Integer>rank;

    public String find(String x) {
        if(parent.get(x).equals(x)) {
            return x;
        }
        String sl = find(parent.get(x));
        parent.put(x,sl);
        return sl;
    }

    public void union(String word1,String word2) {
        String sl1 = find(word1);
        String sl2 = find(word2);

        if(sl1.equals(sl2) == false) {
            //merging
            if(rank.get(sl1) < rank.get(sl2)) {
                parent.put(sl1,sl2);
            }
            else if(rank.get(sl2) < rank.get(sl1)) {
                parent.put(sl2,sl1);
            }
            else {
                parent.put(sl1,sl2);
                rank.put(sl2,rank.get(sl2) + 1);
            }
        }
    }

    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        
        //initialise parent and rank maps
        for(int i=0; i < pairs.size();i++) {
            String word1 = pairs.get(i).get(0);
            String word2 = pairs.get(i).get(1);

            //work on word1
            parent.put(word1,word1);
            rank.put(word1,0);

            //work on word2
            parent.put(word2,word2);
            rank.put(word2,0);
        }


        //apply DSU
        for(int i=0; i < pairs.size();i++) {
            String word1 = pairs.get(i).get(0);
            String word2 = pairs.get(i).get(1);

            union(word1,word2);
        }


        //verification
        if(words1.size() != words2.size()) {
            return false;
        }

        for(int i=0; i < words1.size();i++) {
            String word1 = words1.get(i);
            String word2 = words2.get(i);

            if(word1.equals(word2) == true) {
                continue;
            }
            else if(parent.containsKey(word1) == false || parent.containsKey(word2) == false) {
                return false;
            }
            else {
                String sl1 = find(word1);
                String sl2 = find(word2);

                if(sl1.equals(sl2) != true) {
                    return false;
                } 
            }
        }

        return true;
    }
}