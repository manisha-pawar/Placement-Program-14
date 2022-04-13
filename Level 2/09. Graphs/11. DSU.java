public class DSU {
    public static void main(String[]args) {
        int[][]relations = {{1,3},{2,5},{6,7},{2,4},{1,6},{8,9},{8,10}};
        int n = 10;
        int[]parent = new int[n+1];
        int[]rank = new int[n+1];

        for(int i=1; i <= n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i=0; i < relations.length;i++) {
            int u = relations[i][0];
            int v = relations[i][1];

            union(parent,rank,u,v);
        }


        //number of groups
        int groups = 0;

        for(int i=1; i <= n;i++) {
            if(parent[i] == i) {
                groups++;
            }
        }

        System.out.println(groups);
    }


    public static int find(int x,int[]parent) {
        if(parent[x] == x) {
            return x;
        }

        int sl = find(parent[x],parent);
        parent[x] = sl; //path compression
        return sl;
    }

    public static void union(int[]parent,int[]rank,int u,int v) {
        int slu = find(u,parent);
        int slv = find(v,parent);

        if(slu != slv) {
            int rslu = rank[slu];
            int rslv = rank[slv];

            if(rslu < rslv) {
                parent[slu] = slv;
            }
            else if(rslv < rslu) {
                parent[slv] = slu;
            }
            else {
                parent[slu] = slv;
                rank[slv]++;
            }
        }
    }
}