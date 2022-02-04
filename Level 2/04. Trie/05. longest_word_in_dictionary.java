class Solution {
    static class Node {
        Node[]children;
        boolean isEnd;
        
        Node() {
            children = new Node[26];
            isEnd = false;
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
    
    public String longestWord(String[] words) {
        root = new Node();
        ans = "";
        
        for(String word : words) {
            insert(word);
        }
        
        dfs(root,"");
        return ans;
    }
    
    String ans;
    public void dfs(Node curr,String psf) {
        
        if(psf.length() > ans.length()) {
            ans = psf;
        }
        
        for(int i=0; i < 26;i++) {
            if(curr.children[i] != null) {
                Node child = curr.children[i];
                
                if(child.isEnd == false) {
                    continue;
                }
                else {
                    dfs(child,psf + (char)(i + 'a'));
                }
            }
        }
    }
    
    
}