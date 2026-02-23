package Heap_And_PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;



public class IPO_LeetCode {
    public static void main(String[] args) {
        int k = 2, w = 0;
        int []profits = {1, 2, 3};
        int []capital = {0, 1, 1};

        int maximizedCapital = findMaximizedCapital(k, w, profits, capital);
        System.out.println("maximizedCapital : "+maximizedCapital);
    }

    static class Project implements Comparable<Project>{
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo(Project that) {
            return this.capital - that.capital;     //inc
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minPQ = new PriorityQueue<>();
        int n = capital.length;
        //insert project in minPQ
        for (int i = 0; i < n; i++) {
            minPQ.offer(new Project(profits[i], capital[i]));
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        while (k > 0){
            // fill all projects whose capital is less than or equal to w
            while (!minPQ.isEmpty() && minPQ.peek().capital <= w){
                maxPQ.offer(minPQ.poll().profit);
            }
            if (maxPQ.isEmpty()) break;
            w+=maxPQ.poll();
            k--;
        }
        return w;
    }
}