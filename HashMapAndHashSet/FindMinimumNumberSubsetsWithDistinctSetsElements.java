package HashMapAndHashSet;

import java.util.HashMap;
import java.util.HashSet;

public class FindMinimumNumberSubsetsWithDistinctSetsElements {
    public static void main(String[] args) {
        //set one -> 2, 1, 4, 6, 5
        //set two -> 1, 5
        //set three -> 5

        int []arr = {2, 1, 4, 1, 6, 5, 5, 5};
        int res1 = findMinNumberOfDistinctSets1(arr);
        System.out.println("Min Number of subsets -> "+res1);


        int res2 = findMinNumberOfDistinctSets2(arr);
        System.out.println("Min Number of subsets -> "+res2);
    }


    private static int findMinNumberOfDistinctSets1(int[] arr) {
        int res = 0;
        int n = arr.length;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]){
                continue;
            }
            res++;
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (visited[j] || set.contains(arr[j])){
                    continue;
                }
                visited[j] = true;
                set.add(arr[j]);
            }
        }
        return res;
    }

    private static int findMinNumberOfDistinctSets2(int[] arr) {
        int maxFreq = 0;
        int n = arr.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(arr[i]));
        }
        return maxFreq;
    }
}
