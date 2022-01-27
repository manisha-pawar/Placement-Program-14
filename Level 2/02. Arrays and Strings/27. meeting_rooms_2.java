/**
 * Definition of Interval:
 * public classs Interval {
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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->Integer.compare(a.end,b.end));
        int countrooms=1;
        int j=0;
        Interval prev=intervals.get(0);
        int i=1;
        while(i<intervals.size())
        {
            if(intervals.get(i).start < prev.end)
            {
                countrooms++;
                i++;
            }
            else{
                j++;
                i++;
                prev=intervals.get(j);
            }
        }

        int ans=countrooms;
        return ans;

    }
}