class WordDictionary {
    
    static class Node {
        Node[]children;
        boolean isEnd;
        
        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
    
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return helper(root,word,0);
    }
    
    public boolean helper(Node curr,String word,int idx) {
        if(idx == word.length()) {
            return curr.isEnd;
        }
        
        char ch = word.charAt(idx);
        
        if(ch == '.') {
            for(int i=0; i < 26;i++) {
                if(curr.children[i] != null && helper(curr.children[i],word,idx+1) == true) {
                    return true;
                }
            }
        }
        else {
            if(curr.children[ch-'a'] != null) {
                return helper(curr.children[ch-'a'],word,idx+1);
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */