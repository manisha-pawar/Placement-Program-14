import java.util.*;
 
 public class Main {
 	 public static boolean areKAnagrams(String s1, String s2, int k) {
 	 	 HashMap<Character,Integer>map = new HashMap<>();
 	 	 
 	 	 //populate map using s1
 	 	 for(int i=0; i < s1.length();i++) {
 	 	     char ch = s1.charAt(i);
 	 	     int nf = map.getOrDefault(ch,0) + 1;
 	 	     map.put(ch,nf);
 	 	 }
 	 	 
 	 	 //destroy map using s2
 	 	  for(int i=0; i < s2.length();i++) {
 	 	     char ch = s2.charAt(i);
 	 	     int nf = map.getOrDefault(ch,0) - 1;
 	 	     map.put(ch,nf);
 	 	 }
 	 	 
 	 	 //summation of +ve or -ve values from the map
 	 	 int ro = 0; //required opr
 	 	 for(char key : map.keySet()) {
 	 	     if(map.get(key) > 0) {
 	 	         ro += map.get(key);
 	 	     }
 	 	 }
 	 	 
 	 	 return ro <= k;
 	 }
 
 	 //Don't make changes here
 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 String str1 = s.next();
 	 	 String str2 = s.next();
 	 	 int k = s.nextInt();
 	 	 System.out.println(areKAnagrams(str1, str2, k));
 
 	 }
 
 }