package Heap_And_PriorityQueue;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        int []arr ={4, 2, 7, 6, 9};

        int minCost = minCost(arr);
        System.out.println("minCost : "+minCost);
    }

    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int element : arr){
            minHeap.offer(element);
        }
        //find the min cost
        int cost = 0;
        while (minHeap.size() > 1){
            int rope1 = minHeap.poll();
            int rope2 = minHeap.poll();
            int newRope = rope1 + rope2;
            cost += newRope;
            minHeap.offer(newRope);
        }
        return cost;
    }
}
