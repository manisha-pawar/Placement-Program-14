import java.util.*;

public class Main {

    //count of substrings with atmost k distinct char
    public static int atmostKDistinct(String str,int k) {
        HashMap<Character,Integer>map = new HashMap<>();
        int i = -1;
        int j = -1;
        int count = 0;
        
        while(i < str.length()-1) {
            //aquire
            while(i < str.length()-1 && map.size() <= k) {
                i++;
                
                char ch = str.charAt(i);
                int nf = map.getOrDefault(ch,0) + 1;
                map.put(ch,nf);
                
                if(map.size() <= k) {
                    count += (i-j);
                }
            }
            
            //release
            while(j < i && map.size() > k) {
                j++;
                
                char ch = str.charAt(j);
                
                if(map.get(ch) == 1) {
                    map.remove(ch);
                    count += (i-j);
                }
                else {
                    int nf = map.get(ch) - 1;
                    map.put(ch,nf);
                }
            }
        }
        
        return count;
    }
    
	public static int solution(String str, int k){
		// write your code here

		int ans = atmostKDistinct(str,k) - atmostKDistinct(str,k-1);
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
