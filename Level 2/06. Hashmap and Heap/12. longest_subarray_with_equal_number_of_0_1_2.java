import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        HashMap<String,Integer>map = new HashMap<>(); //(c0-c1)@(c1-c2) vs first index
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        map.put("0@0",-1);
        int olen = 0;
        
        for(int i=0; i < arr.length;i++) {
            if(arr[i] == 0) {
                c0++;
            }
            else if(arr[i] == 1) {
                c1++;
            }
            else {
                c2++;
            }
            
            String state = (c0-c1) + "@" + (c1-c2);
            
            if(map.containsKey(state) == true) {
                int len = i - map.get(state);
                olen = Math.max(olen,len);
            }
            else {
                map.put(state,i);
            }
        }
        
        return olen;
        
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
