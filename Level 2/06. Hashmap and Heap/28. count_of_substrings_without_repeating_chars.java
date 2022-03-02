import java.util.*;

public class Main {

	public static int solution(String str) {
	    int count = 0;
	    HashMap<Character,Integer>map = new HashMap<>();
	    int i = -1;
	    int j = -1;
	    
	    while(i < str.length()-1) {
	        //aquire
	        while(i <  str.length()-1) {
	            i++;
	            
	            char ch = str.charAt(i);
	            int nf = map.getOrDefault(ch,0) + 1;
	            map.put(ch,nf);
	            
	            if(nf == 2) {
	                //invalid
	                break;
	            }
	            else {
	                count += (i - j); //answers -> j+1 to i (starting points) and i (end point)
	            }
	        }
	        
	        //release
	        while(j < i) {
	            j++;
	            
	            char ch = str.charAt(j);
	            
	            if(map.get(ch) == 1) {
	                map.remove(ch);
	            }
	            else {
	                map.put(ch,1);
	                //you are valid again
	                count += (i - j); //answers -> j+1 to i (starting points) and i (end point)
	                break;
	            }
	        }
	    }
	    
	    return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
