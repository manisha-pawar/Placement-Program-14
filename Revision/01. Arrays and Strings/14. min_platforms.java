//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

class Solution {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.

    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int temp = 0;
        int ans = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                temp++;
                i++;
            } 
            else {
                temp--;
                j++;
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    }
}