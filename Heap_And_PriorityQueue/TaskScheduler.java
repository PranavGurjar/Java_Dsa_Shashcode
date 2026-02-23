package Heap_And_PriorityQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
//        char []tasks = {'C', 'C', 'C', 'Z', 'Z', 'M', 'M'};
        String tasks = "CCCZZMM";
        int n = 1;

        int leastInterval = leastInterval(tasks.toCharArray(), n);
        System.out.println("leastInterval : "+leastInterval);
    }

    static class Task implements Comparable<Task>{
        int frequency;
        int executionTime;

        public Task(int frequency, int executionTime) {
            this.frequency = frequency;
            this.executionTime = executionTime;
        }


        @Override
        public int compareTo(Task that) {
            return that.frequency - this.frequency;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        //freq
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : tasks){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }

        //insertion in max heap - PQ
        PriorityQueue<Task> pq = new PriorityQueue<>();

        //insert tasks in pq
        for (Character ch : freqMap.keySet()){
            int freq = freqMap.get(ch);
            pq.offer(new Task(freq, 0));
        }
        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while (!queue.isEmpty() || !pq.isEmpty()){
            time++;
            //check if there is a task in pq & process it
            if (!pq.isEmpty()){
                Task task = pq.poll();
                task.frequency--;
                if (task.frequency > 0){
                    //update the execution time = current time + cooldown time
                    task.executionTime = time + n;
                    queue.offer(task);
                }
            }
            //shift the active process to the pq
            if (!queue.isEmpty() && queue.peek().executionTime == time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}