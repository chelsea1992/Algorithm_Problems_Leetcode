/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
        // Override    
           public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            } 
        });
        
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
         for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) {
                res.add(inter);
                prev = inter;
            } else{
                prev.end = Math.max(inter.end,prev.end);
            }
        }
        return res;
    }
}
