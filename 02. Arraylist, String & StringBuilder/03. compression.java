import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		// write your code here
        StringBuilder ans = new StringBuilder("");
        
        for(int i=0; i < str.length()-1;i++) {
            char c = str.charAt(i);
            char n = str.charAt(i+1);
            
            if(c != n) {
                ans.append(c);
            }
            
        }
        
        char lch = str.charAt(str.length()-1);
        ans.append(lch);
        
		return ans.toString();
	}

	public static String compression2(String str){
		// write your code here

		return null;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		//System.out.println(compression2(str));
	}

}