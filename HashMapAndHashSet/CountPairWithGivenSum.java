package HashMapAndHashSet;

import java.util.HashMap;


//Count Pair with given sum | count pair with sum |
public class CountPairWithGivenSum {
    public static void main(String[] args) {
        int []arr = {1, 5, 7, 1};
        int target = 6;

        System.out.println("Count Pair1 : "+countPairs1(arr, target));
        System.out.println("Count Pair2 : "+countPairs2(arr, target));
    }

    public static int countPairs1(int arr[], int target) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target){
                continue;
            }
            int secondVal = target - arr[i];
            if (freqMap.getOrDefault(secondVal, 0)>0){
                res+=freqMap.get(secondVal);
                freqMap.put(arr[i], freqMap.get(arr[i])-1);
                if (arr[i] == secondVal){
                    res-=1;
                }
            }
        }
        return res;
    }

    public static int countPairs2(int arr[], int target) {
        int res = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target){
                continue;
            }
            int secondVal = target - arr[i];
            res += freqMap.getOrDefault(secondVal, 0);
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
        }
        return res;
    }
}
