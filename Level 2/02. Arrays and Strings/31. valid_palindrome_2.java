class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                return isPalindromic(s,i+1,j) || isPalindromic(s,i,j-1);
            }
        }
        
        return true;
    }
    
    public static boolean isPalindromic(String str,int i,int j) {
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}