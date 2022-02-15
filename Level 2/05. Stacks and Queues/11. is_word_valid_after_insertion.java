class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == 'a' || ch == 'b') {
                st.push(ch);
            }
            else {
                if(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a') {
                    //no issues
                }
                else {
                    return false;
                }
            }
        }
        
        return st.size() == 0;
    }
}