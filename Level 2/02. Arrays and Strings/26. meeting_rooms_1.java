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
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
         if(intervals.size() == 0) {
             return true;
         }

         Collections.sort(intervals, (a,b)->{
            return a.start - b.start;
         });

         int liep = intervals.get(0).end;
         int i = 1;

         while(i < intervals.size()) {
             int isp = intervals.get(i).start;
             if(isp < liep) {
                 return false;
             }
             else {
                 liep = Math.max(intervals.get(i).end,liep);
             }
             i++;
         }

         return true;

    }
}