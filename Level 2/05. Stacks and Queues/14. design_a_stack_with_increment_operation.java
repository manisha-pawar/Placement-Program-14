class CustomStack {

    int[]value;
    int[]increment;
    int tos;
    
    public CustomStack(int maxSize) {
        value = new int[maxSize];
        increment = new int[maxSize];
        tos = -1;
    }
    
    public void push(int x) {
        if(tos + 1 == value.length) {
            //overflow
            return;
        }
        
        tos++;
        value[tos] = x;
    }
    
    public int pop() {
        if(tos == -1) {
            //underflow
            return -1;
        }
        
        int rv = value[tos] + increment[tos];
        int inc = increment[tos];
        
        value[tos] = increment[tos] = 0;
        tos--;
        
        if(tos >= 0)
        increment[tos] += inc;
        
        return rv;
    }
    
    public void increment(int k, int inc) {
        if(tos == -1) {
            return;
        }
        
        if(k > tos+1) {
            increment[tos] += inc;
        }
        else {
            increment[k-1] += inc;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */