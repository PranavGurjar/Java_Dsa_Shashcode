package Greedy_Algorithm_For_Interviews;

import java.util.Arrays;



public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int [][]boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        int maximumUnits = maximumUnits(boxTypes, truckSize);
        System.out.println("maximumUnits : "+maximumUnits);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort in decreasing order of ratio
        //a[1], b[1] -> value of 1 item
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);       //NLogN
        int res = 0;
        //N
        for (int boxType[] : boxTypes){
            if (boxType[0] >= truckSize){
                res += (truckSize * boxType[1]);
                truckSize = 0;
            }
            else {
                res += (boxType[0] * boxType[1]);
                truckSize -= boxType[0];
            }
            if (truckSize == 0) break;
        }
        return res;
    }
}