import java.util.*;

public class Main {

    public static List < List < Integer >> targetSumUniquePairs(int si, int[] arr, int target) {
        List < List < Integer >> ans = new ArrayList < > ();

        int i = si;
        int j = arr.length - 1;

        while (i < j) {
            if (i - 1 >= si && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }

            if (arr[i] + arr[j] == target) {
                ArrayList < Integer > pair = new ArrayList < > ();
                pair.add(arr[i]);
                pair.add(arr[j]);
                ans.add(pair);

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

    public static List < List < Integer >> kSum(int[] arr, int target, int k) {
        Arrays.sort(arr);
        return helper(0, arr, target, k);
    }


    public static List < List < Integer >> helper(int idx, int[] arr, int target, int k) {
        if (k == 2) {
            return targetSumUniquePairs(idx, arr, target);
        }

        List < List < Integer >> ans = new ArrayList < > ();

        for (int i = idx; i < arr.length - (k - 1); i++) {
            if (i - 1 >= idx && arr[i] == arr[i - 1]) {
                continue;
            }

            List < List < Integer >> sl = helper(i + 1, arr, target - arr[i], k - 1);

            for (int j = 0; j < sl.size(); j++) {
                sl.get(j).add(arr[i]); //k-1 elements set to k elements set
                ans.add(sl.get(j));
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List < List < Integer >> res = kSum(arr, target, k);
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