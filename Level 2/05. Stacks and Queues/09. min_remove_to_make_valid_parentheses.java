class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer>st = new Stack<>();
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
                
            if(ch == '(') {
                st.push(i);
            }   
            else if(ch == ')'){
                if(st.size() > 0  && s.charAt(st.peek()) == '(') {
                    st.pop();
                }
                else {
                    st.push(i);
                }
            }
        }
        
        
        char[]arr = s.toCharArray();
        
        while(st.size() > 0) {
            int idx = st.pop();
            arr[idx] = '.';
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < arr.length;i++) {
            if(arr[i] != '.') {
                sb.append(arr[i]);
            }
        }
        
        return sb.toString();
        
        
    }
}