class Solution {
    static class Pair {
        int bus_stand;
        int lev;
        
        Pair() {
            
        }
        
        Pair(int bus_stand,int lev) {
            this.bus_stand = bus_stand;
            this.lev = lev;
        }
    }
    
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>(); //bus stand vs bus no.
        
        for(int i=0; i < routes.length;i++) {
            for(int j=0; j < routes[i].length;j++) {
                int bus = i;
                int bus_stand = routes[i][j];
                
                ArrayList<Integer>list = map.getOrDefault(bus_stand,new ArrayList<>());
                list.add(bus);
                map.put(bus_stand,list);
            }
        }
        
        
        return bfs(routes,map,source,target);   
    }
    
    
    public int bfs(int[][]routes,HashMap<Integer,ArrayList<Integer>>map,int src,int dest) {
        ArrayDeque<Pair>q = new ArrayDeque<>();
        HashSet<Integer>vis_bus_stand = new HashSet<>();
        HashSet<Integer>vis_bus = new HashSet<>();
        
        q.add(new Pair(src,0));
        vis_bus_stand.add(src);
        
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.bus_stand == dest) {
                return rem.lev;
            }
            
            for(int bus : map.get(rem.bus_stand)) {
                if(vis_bus.contains(bus) == false) {
                    vis_bus.add(bus);
                    for(int bus_stand : routes[bus]) {
                        if(vis_bus_stand.contains(bus_stand) == false) {
                            q.add(new Pair(bus_stand,rem.lev + 1));
                            vis_bus_stand.add(bus_stand);
                        }
                    }
                }
            }           
        }
        
        
        return -1;
        
    }
    
}