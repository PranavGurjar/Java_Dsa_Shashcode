package Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//Josephus problem
public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        int n = 5, k = 2;

        int theWinner1 = findTheWinner1(n, k);
        System.out.println("Winner 1 : "+theWinner1);

        int theWinner2 = findTheWinner2(n, k);
        System.out.println("Winner 2 : "+theWinner2);

        int theWinner3 = findTheWinner3(n, k);
        System.out.println("Winner 3 : "+theWinner3);

        int theWinner4 = findTheWinner4(n, k);
        System.out.println("Winner 4 : "+theWinner4);
    }

    public static int findTheWinner4(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = ((ans + k) % i);
        }
        return ans + 1;
    }

    public static int findTheWinner3(int n, int k) {
        int index = findIndex(n, k);
        return index+1;
    }

    public static int findIndex(int n, int k){
        if (n == 1){
            return 0;
        }
        return ((findIndex(n-1, k) + k) % n);
    }

    public static int findTheWinner2(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        //O(N)
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // time -> N + N*K
        // space -> N
        //O(N * K)
        int index = 0;
        while (queue.size()>1){
            // (k - 1) -> rotation
            // O(N)
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    public static int findTheWinner1(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //O(N)
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // time -> N + N^2
        // space -> N
        //O(N)
        int index = 0;
        while (list.size()>1){
            index = (index + (k-1))%list.size();
            //O(N)
            list.remove(index);
        }
        return list.get(0);
    }
}
