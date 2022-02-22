import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        HashMap<String,Integer>map = new HashMap<>(); //(c0-c1)@(c1-c2) vs count
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        map.put("0@0",1);
        int oans = 0;
        
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
                oans += map.get(state);
            }
            
            int nf = map.getOrDefault(state,0) + 1;
            map.put(state,nf);
        }
        
        return oans;
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
