class Solution {
    
    //T : o(n), S : o(n)
    //follow up T : o(n), S : o(1)
    public int minAddToMakeValid(String s) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                st.push(ch);
            }
            else if(ch == ')') {
                //is '(' available for me
                if(st.size() > 0 && st.peek() == '(') {
                    st.pop();
                }
                else {
                    st.push(ch);
                }
            }
        }
        
        return st.size();
    }
}