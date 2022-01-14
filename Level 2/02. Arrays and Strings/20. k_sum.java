import java.util.*;

public class Main {

    public static List < List < Integer >> kSum(int[] arr, int target, int k) {

        Arrays.sort(arr);
        return KSum(arr, target, k, 0);
    }

    public static List < List < Integer >> tsUniquePairs(int[] nums, int si, int target) {
        int i = si;
        int j = nums.length - 1;

        List < List < Integer >> ans = new ArrayList < > ();

        while (i < j) {
            if (i != si && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (nums[i] + nums[j] == target) {
                ArrayList < Integer > res = new ArrayList < > ();
                res.add(nums[i]);
                res.add(nums[j]);
                ans.add(res);

                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    public static List < List < Integer >> KSum(int[] arr, int target, int k, int si) {
        if (k == 2) {
            return tsUniquePairs(arr, si, target);
        }

        List < List < Integer >> ans = new ArrayList < > ();

        for (int i = si; i < arr.length - k + 1; i++) {
            if (i != si && arr[i] == arr[i - 1]) {
                continue;
            }

            List < List < Integer >> res = KSum(arr, target - arr[i], k - 1, i + 1);

            for (List < Integer > list: res) {
                list.add(arr[i]);
                ans.add(list);
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