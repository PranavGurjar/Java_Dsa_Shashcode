package HashMapAndHashSet;

import java.util.HashMap;


public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int []arr = {1, 2, 7, 1, 6, 4, 3};
        int []brr = {1, 2, 1, 4};

        System.out.println("Is Subset : "+isSubset(arr, brr));
    }

    public static boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (Integer element : a){
            freqMap.put(element, freqMap.getOrDefault(element, 0)+1);
        }

        for (Integer element : b){
//            if (freqMap.containsKey(element) && freqMap.get(element) > 0){
            if (freqMap.getOrDefault(element, 0)>0){
                freqMap.put(element, freqMap.get(element)-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
