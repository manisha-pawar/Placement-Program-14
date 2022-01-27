class Solution {
    public String pushDominoes(String dominoes) {
        String str = 'L' + dominoes + 'R';
        StringBuilder sb = new StringBuilder(str);
        
        int i = 0;
        
        while(i < str.length()-1) {
            int j = i+1;
            
            while(j < str.length() && str.charAt(j) == '.') {
                j++;
            }
            
            //solve i to j
            solve(sb,i,j);
            i = j;
        }
        
        //remove extra 'L','R' which were initially added
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    public static void solve(StringBuilder sb,int i,int j) {
        
        if(sb.charAt(i) == 'L' && sb.charAt(j) == 'L') {
            for(int k = i+1; k <= j-1;k++) {
                sb.setCharAt(k,'L');
            }
        }
        else if(sb.charAt(i) == 'L' && sb.charAt(j) == 'R') {
            //no changes
        }
        else if(sb.charAt(i) == 'R' && sb.charAt(j) == 'R') {
            for(int k = i+1; k <= j-1;k++) {
                sb.setCharAt(k,'R');
            }
        }
        else if(sb.charAt(i) == 'R' && sb.charAt(j) == 'L') {
            while(i < j) {
                sb.setCharAt(i,'R');
                sb.setCharAt(j,'L');
                
                i++;
                j--;
            }
        }
    }
}