class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer>map = new HashMap<>(); //x vs count of gaps
        
        for(List<Integer>list : wall) {
            int ps = 0;
            for(int i=0; i < list.size()-1;i++) {
                ps += list.get(i);
                int nf = map.getOrDefault(ps,0) + 1;
                map.put(ps,nf);
            }
        }
        
        int maxgap = 0;
        
        for(int key : map.keySet()) {
            if(map.get(key) > maxgap) {
                maxgap = map.get(key);
            }
        }
        
        int minbrick = wall.size() - maxgap;
        
        return minbrick;
    }
}