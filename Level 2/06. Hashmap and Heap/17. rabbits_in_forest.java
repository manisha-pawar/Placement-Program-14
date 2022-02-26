class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map = new HashMap<>(); //ans vs count of rabbits
        
        for(int i=0; i < answers.length;i++) {
            int nf = map.getOrDefault(answers[i],0) + 1;
            map.put(answers[i],nf);
        }
        
        int mr = 0;
        
        for(int key : map.keySet()) {
            int val = map.get(key);
            int gs = key + 1;
            mr += Math.ceil(val*1.0/gs) * gs;
        }
        
        return mr;
        
    }
}