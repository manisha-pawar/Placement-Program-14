class StockSpanner {
    ArrayList<Integer>list;
    Stack<Integer>st;

    public StockSpanner() {
        list = new ArrayList<>();
        st = new Stack<>();
    }
    
    public int next(int price) {
        int idx = list.size();
        
        
        while(st.size() > 0 && list.get(st.peek()) <= price) {
            st.pop();
        }
        
        int ans = 0;
        if(st.size() == 0) {
            ans =  idx+1;
        }
        else {
            ans =  idx - st.peek();
        }
        
        st.push(idx);
        list.add(price);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */