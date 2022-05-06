class Solution {
    public List < Integer > getRow(int rowIndex) {
        List < Integer > ans = new ArrayList < > ();

        int n = rowIndex;
        long temp = 1;

        ans.add(1); //nC0

        for (int r = 0; r <= n - 1; r++) {
            temp = (temp * (n - r)) / (r + 1);
            ans.add((int) temp);
        }

        return ans;
    }
}