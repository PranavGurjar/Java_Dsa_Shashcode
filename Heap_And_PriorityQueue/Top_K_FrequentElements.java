package Tree_Data_Structure.Heap_And_PriorityQueue;

import java.util.*;

public class Top_K_FrequentElements {
    public static void main(String[] args) {
        int []nums = {1, 2, 1, 2, 1, 3};
        int k = 2;

        int[] max = topKFrequentUsingMax(nums, k);
        System.out.print("max : ");
        printArray(max);
        System.out.println("max : "+ Arrays.toString(max));

        int[] min = topKFrequentUsingMin(nums, k);
        System.out.print("min : ");
        printArray(min);
        System.out.println("min : "+ Arrays.toString(min));
    }

    public static String printArray(int []nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+", ");
        }
        System.out.println();
        return "";
    }

    static class MinNumber implements Comparable<MinNumber> {
        int element;
        int freq;

        public MinNumber(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }

        @Override
        public int compareTo(MinNumber that) {
            //min heap
            return this.freq - that.freq;       //inc
        }
    }

    static class MaxNumber implements Comparable<MaxNumber> {
        int element;
        int freq;

        public MaxNumber(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }

        @Override
        public int compareTo(MaxNumber that) {
            //max heap
            return that.freq - this.freq;       //dec
        }
    }

    public static int[] topKFrequentUsingMin(int[] nums, int k) {
        PriorityQueue<MinNumber> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        //find freq of all element
        for (int element : nums){
            freqMap.put(element, freqMap.getOrDefault(element, 0)+1);
        }

        //insert element in pq
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            MinNumber minNumber = new MinNumber(entry.getKey(), entry.getValue());
            pq.offer(minNumber);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int res[] = new int[k];
        int index = 0;
        while (index < k){
            MinNumber minNumber = pq.poll();
            res[index] = minNumber.element;
            index++;
        }
        return res;
    }


    public static int[] topKFrequentUsingMax(int[] nums, int k) {
        PriorityQueue<MaxNumber> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        //find freq of all element
        for (int element : nums){
            freqMap.put(element, freqMap.getOrDefault(element, 0)+1);
        }

        //insert element in pq
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            MaxNumber number = new MaxNumber(entry.getKey(), entry.getValue());
            pq.offer(number);
        }

        int res[] = new int[k];
        int index = 0;
        while (index < k){
            MaxNumber maxNumber = pq.poll();
            res[index] = maxNumber.element;
            index++;
        }
        return res;
    }
}