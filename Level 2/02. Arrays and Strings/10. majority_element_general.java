import java.util.*;

public class Main {

    //~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList < Integer > majorityElement(int[] arr, int k) {
        ArrayList < Integer > ans = new ArrayList < > ();

        //freq map
        HashMap < Integer, Integer > map = new HashMap < > ();

        for (int val: arr) {
            if (map.containsKey(val) == false) {
                map.put(val, 1);
            } else {
                int nf = map.get(val) + 1;
                map.put(val, nf);
            }
        }

        for (int key: map.keySet()) {
            int freq = map.get(key);

            if (freq > arr.length / k) {
                ans.add(key);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    //~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList < Integer > res = majorityElement(arr, k);
        System.out.println(res);
    }
}