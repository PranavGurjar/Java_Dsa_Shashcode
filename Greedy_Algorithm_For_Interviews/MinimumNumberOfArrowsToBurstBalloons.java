package Greedy_Algorithm_For_Interviews;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int [][]points = {{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println("minArrowShots : "+minArrowShots);
    }

    //T -> NLogN
    public static int findMinArrowShots(int[][] points) {
        //a, b -> swap -> pos(1)    //-1 and 1
        // (2, 4), (6, 8)
        Arrays.sort(points, (a, b) -> (a[1] <= b[1])?-1:1); //nlogn
        int arrows = 1;
        int lastEnd = points[0][1];
        for (int point[] : points){
            //if there is no overlapping point then increase the arrow
            if (point[0] > lastEnd){
                arrows++;
                lastEnd = point[1];
            }
        }
        return arrows;
    }
}
