import java.util.*;

public class Main {

    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List < List < Integer >> twoSum(int[] arr, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            //cosider unique pairs only
            if (i != 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }

            if (arr[i] + arr[j] == target) {
                ArrayList < Integer > res = new ArrayList < > ();
                res.add(arr[i]);
                res.add(arr[j]);
                ans.add(res);

                i++;
                j--;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List < List < Integer >> res = twoSum(arr, target);
        ArrayList < String > finalResult = new ArrayList < > ();
        for (List < Integer > list: res) {
            Collections.sort(list);
            String ans = "";
            for (int val: list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str: finalResult) {
            System.out.println(str);
        }
    }
}