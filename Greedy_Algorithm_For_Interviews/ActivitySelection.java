package Greedy_Algorithm_For_Interviews;

import java.util.ArrayList;
import java.util.Collections;


public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};
        int activitySelection = activitySelection(start, finish);
        System.out.println("activitySelection : "+activitySelection);
    }

    public static int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        ArrayList<Integer> indexArr = new ArrayList<>();
        //N
        for (int i = 0; i < n; i++) {
            indexArr.add(i);
        }
        //sorting
        //{0, 1, 2, 3, 4, 5}
        //NLogN
        Collections.sort(indexArr, (a, b) -> (finish[a] - finish[b]));
        int maxActivity = 1;
        int lastEnd = finish[indexArr.get(0)];
        //N
        for (int i = 1; i < n; i++) {
            int index = indexArr.get(i);
            if (start[index] > lastEnd){
                maxActivity++;
                lastEnd = finish[index];
            }
        }
        return maxActivity;
    }
}