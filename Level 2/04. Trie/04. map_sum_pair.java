class MapSum {

    static class Node {
        Node[]children;
        boolean isEnd; //no use
        int score;
        
        Node() {
            children = new Node[26];
            isEnd = false;
            score = 0;
        }
    }
    Node root;
    HashMap<String,Integer>map;
    
    public MapSum() {
        root = new Node();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int temp = val - map.getOrDefault(key,0);
        map.put(key,val);
        
        Node curr = root;
        
        for(int i=0; i < key.length();i++) {
            char ch = key.charAt(i);
            
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node();
            }
            
            curr = curr.children[ch-'a'];
            curr.score += temp;
        }
        
        curr.isEnd = true;
    }
    
    public int sum(String prefix) {
        int ans = 0;
        
        Node curr = root;
        
        for(int i=0; i < prefix.length();i++) {
            char ch = prefix.charAt(i);
            
            if(curr.children[ch-'a'] == null) {
                return 0;
            }
            
            curr = curr.children[ch-'a'];
        }
        
        return curr.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */