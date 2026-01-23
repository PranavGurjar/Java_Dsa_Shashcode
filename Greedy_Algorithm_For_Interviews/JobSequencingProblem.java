package Greedy_Algorithm_For_Interviews;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencingProblem {
    public static void main(String[] args) {
        int []deadline = {4, 1, 1, 1};
        int []profit = {20, 10, 40, 30};
        ArrayList<Integer> jobSequencing = jobSequencing(deadline, profit);
        System.out.println("jobSequencing : "+jobSequencing);
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int len = profit.length;
        int n = 0;
        for (int d : deadline){
            n = Math.max(n, d);
        }
        int assignedJobs[] = new int[n+1];
        Arrays.fill(assignedJobs, -1);
        Integer index[] = new Integer[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> profit[b]-profit[a]);
        int count = 0;
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            int ind = index[i];
            int d = deadline[ind];
            while (d > 0 && assignedJobs[d] != -1) d--;
            if (d == 0) continue;
            count++;
            assignedJobs[d] = 1;
            maxProfit += profit[ind];
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(maxProfit);
        return res;
    }
}
