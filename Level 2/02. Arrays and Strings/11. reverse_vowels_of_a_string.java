//https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public static boolean IsVowel(char ch) {
        String vowels = "aeiouAEIOU";
        
        int idx = vowels.indexOf(ch);
        
        if(idx == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1; 
        
        char[]arr = s.toCharArray();
        
        while(i < j) {
            while(i < j && IsVowel(arr[i]) == false) {
                i++;
            }
            while(i < j && IsVowel(arr[j]) == false) {
                j--;
            }
            
            char temp = arr[i]; 
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
        
        return new String(arr);
    }
}