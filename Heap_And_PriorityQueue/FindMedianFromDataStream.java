package Heap_And_PriorityQueue;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.addNum(1);
        System.out.println("Median : "+mf.findMedian());
        mf.addNum(3);
        System.out.println("Median : "+mf.findMedian());
        mf.addNum(2);
        mf.addNum(4);
        System.out.println("Median : "+mf.findMedian());
        mf.addNum(5);
        System.out.println("Median : "+mf.findMedian());
    }

    static class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>((a, b) -> (a - b));   //inc
            maxHeap = new PriorityQueue<>((a, b) -> (b - a));   //dec
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            //<=
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int val = maxHeap.poll();
                minHeap.offer(val);
            }
            //size check
            if (maxHeap.size() > minHeap.size() + 1) {
                int val = maxHeap.poll();
                minHeap.offer(val);
            }
            if (minHeap.size() > maxHeap.size() + 1) {
                int val = minHeap.poll();
                maxHeap.offer(val);
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}

