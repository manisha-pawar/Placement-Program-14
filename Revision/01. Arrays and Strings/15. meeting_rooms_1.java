//https://www.lintcode.com/problem/920/

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
     * @return: if a person could attend all meetings
     */

    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) {
            return true;
        }

        Collections.sort(intervals,(a,b)->{
            return a.start - b.start;
        });

        int lmep = intervals.get(0).end; 

        for(int i=1; i < intervals.size();i++) {
            int cmsp = intervals.get(i).start; 

            if(lmep > cmsp) {
                return false;
            }
        }

        return true;
    }
}