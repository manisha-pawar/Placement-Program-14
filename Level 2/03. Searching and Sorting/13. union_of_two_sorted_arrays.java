class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer>ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < n && j < m) {
            if(arr1[i] <= arr2[j]) {
                if(ans.size() == 0) {
                    ans.add(arr1[i]);
                }
                else if(ans.get(ans.size()-1) != arr1[i]) {
                    ans.add(arr1[i]);
                }
                i++;
            }
            else {
                if(ans.size() == 0) {
                    ans.add(arr2[j]);
                }
                else if(ans.get(ans.size()-1) != arr2[j]) {
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        
        while(i < n) {
            if(ans.get(ans.size()-1) != arr1[i]) {
                    ans.add(arr1[i]);
            }
            i++;
        }
        
        while(j < m) {
            if(ans.get(ans.size()-1) != arr2[j]) {
                    ans.add(arr2[j]);
            }
            j++;
        }
        
        return ans;
    }
}
