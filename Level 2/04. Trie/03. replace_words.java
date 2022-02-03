class Solution {
    static class Node {
        Node[]children;
        boolean isEnd;
        
        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
    Node root;
    public void insert(String word) {
        Node curr = root;
        
        for(int i=0; i < word.length();i++) {
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public String searchPrefix(String word,Node root) {
        Node curr = root;
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i < word.length();i++) {
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a'] == null) {
               return null;
            }
            
            sb.append(ch);
            curr = curr.children[ch-'a'];
            
            if(curr.isEnd == true) {
                return sb.toString();
            }
            
        }
        
        return null;   
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        
        //fill all words of dictionary in "Trie"
        for(String word : dictionary) {
            insert(word);
        }
        
        String[]wordsArr = sentence.split(" ");
        
        for(int i=0; i < wordsArr.length;i++) {
            String prefix = searchPrefix(wordsArr[i],root);
            
            if(prefix != null) {
                wordsArr[i] = prefix;
            }
        }
        
        String ans = String.join(" ",wordsArr);
        return ans;
    }
    
}