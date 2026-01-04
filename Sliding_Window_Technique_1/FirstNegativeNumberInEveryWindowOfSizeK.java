package Sliding_Window_Technique_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class FirstNegativeNumberInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int []arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int[] firstNegInt1 = firstNegInt1(arr, 3);
        System.out.print("firstNegInt1 : ");
        for (int i = 0; i < firstNegInt1.length; i++) {
            System.out.print(firstNegInt1[i]);
            if (i != firstNegInt1.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();

        List<Integer> firstNegInt2 = firstNegInt2(arr, 3);
        System.out.println("firstNegInt2 : "+firstNegInt2);
    }

    static List<Integer> firstNegInt2(int []arr, int K) {
        int N = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        //calculate for first window
        int index = 0;
        while (index < K){
            if (arr[index] < 0){
                queue.offer(arr[index]);
            }
            index++;
        }

        ArrayList<Integer> res = new ArrayList<>(N-K+1);
        int res1 = (queue.isEmpty())?0:queue.peek();
        res.add(res1);

        for (int i = 1; i < (N-K+1); i++) {
            //remove
            if (arr[i-1] < 0){
                queue.poll();
            }
            //add
            if (arr[i+K-1] < 0){
                queue.offer(arr[i+K-1]);
            }
            int res2 = (queue.isEmpty())?0:queue.peek();
            res.add(res2);
        }
        return res;
    }

    static int[] firstNegInt1(int []arr, int K) {
        int N = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        //calculate for first window
        int index = 0;
        while (index < K){
            if (arr[index] < 0){
                queue.offer(arr[index]);
            }
            index++;
        }

        int []res = new int[N-K+1];
        res[0] = (queue.isEmpty())?0:queue.peek();

        for (int i = 1; i < (N-K+1); i++) {
            //remove
            if (arr[i-1] < 0){
                queue.poll();
            }
            //add
            if (arr[i+K-1] < 0){
                queue.offer(arr[i+K-1]);
            }
            res[i] = (queue.isEmpty())?0:queue.peek();
        }
        return res;
    }
}
