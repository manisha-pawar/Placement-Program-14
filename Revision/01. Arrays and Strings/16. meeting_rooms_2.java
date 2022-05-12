//https://www.lintcode.com/problem/919/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List < Interval > intervals) {
        int[] arr = new int[intervals.size()];
        int[] dep = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            arr[i] = intervals.get(i).start;
            dep[i] = intervals.get(i).end;
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int temp = 0;
        int ans = 0;


        while (i < intervals.size() && j < intervals.size()) {
            if (arr[i] < dep[j]) {
                temp++;
                i++;
            } else {
                temp--;
                j++;
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    }
}