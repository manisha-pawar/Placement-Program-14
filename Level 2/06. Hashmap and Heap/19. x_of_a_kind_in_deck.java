class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int i=0; i < deck.length;i++) {
            int nf = map.getOrDefault(deck[i],0) + 1;
            map.put(deck[i],nf);
        }
        
        int gcd = 0;
        for(int key : map.keySet()) {
            gcd = GCD(gcd,map.get(key));
        }
        
        if(gcd == 1) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public int GCD(int a,int b) {
        if(b == 0) {
            return a;
        }
        
        return GCD(b,a % b);
    }
}