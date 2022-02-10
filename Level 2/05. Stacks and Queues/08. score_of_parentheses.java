class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st = new Stack<>();
        
        //-1 -> represents the presence '('
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                st.push(-1);
            }
            else {
                if(st.peek() == -1) {
                    st.pop();
                    st.push(1);
                }
                else {
                    int sc = 0;
                    while(st.peek() != -1) {
                        sc += st.pop();
                    }
                    st.pop();
                    st.push(2*sc);
                }
            }
        }
        
        int ans = 0;
        
        while(st.size() > 0) {
            ans += st.pop();
        }
        
        return ans;
        
    }
}