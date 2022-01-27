class Solution
{
     static class RC implements Comparable<RC>{
        int p;
        int c;
        int m;
        
        RC(int p,int c,int m) {
            this.p = p;
            this.c = c;
            this.m = m;
        }
        
        public int compareTo(RC o) {
            if(this.p != o.p) {
                return this.p - o.p;
            }
            else if(this.c != o.c) {
                return -(this.c - o.c);
            }
            else {
                return this.m - o.m;
            }
        }
    }
    
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        RC[]arr = new RC[N];
        
        for(int i=0; i < N;i++) {
            RC obj = new RC(phy[i],chem[i],math[i]);
            arr[i] = obj;
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i < N;i++) {
            RC obj = arr[i];
            phy[i] = obj.p;
            chem[i] = obj.c;
            math[i] = obj.m;
        }
        
    }
 
}
