class StreamChecker {
    static class Node {
        Node[]children = new Node[26];
        boolean isEnd = false;
    }
    
    public void insert(String word) {
        Node curr = root;
        
        for(int i=word.length()-1; i >= 0;i--) {
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    StringBuilder sb;
    Node root;
    public StreamChecker(String[] words) {
        sb = new StringBuilder("");
        root = new Node();
        
        //insert all words in "Trie"
        for(String word : words) {
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        Node curr = root;
        
        sb.append(letter);
        
        for(int i=sb.length()-1 ; i >= 0;i--) {
            char ch = sb.charAt(i);
            
            Node child = curr.children[ch-'a'];
            
            if(child == null) {
                return false;
            }
            else if(child.isEnd == true){
                return true;
            }
            
            curr = child;
        }
        
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */