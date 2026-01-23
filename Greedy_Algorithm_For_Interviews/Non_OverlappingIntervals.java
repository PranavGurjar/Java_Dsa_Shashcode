package Greedy_Algorithm_For_Interviews;

import java.util.Arrays;


public class Non_OverlappingIntervals {
    public static void main(String[] args) {
        int [][]intervals = {{1,2},{2,3},{3,4},{1,3}};
        int eraseOverlapIntervals = eraseOverlapIntervals(intervals);
        System.out.println("eraseOverlapIntervals : "+eraseOverlapIntervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
//        [[s, e], [s, e], [s, e]]
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);      //NLogN
        int removed = 0;
        int lastEnd = intervals[0][1];
        //O(N)
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < lastEnd){     //overlap
                removed++;
            }
            else {
                lastEnd = intervals[i][1];
            }
        }
        return removed;
    }
}
