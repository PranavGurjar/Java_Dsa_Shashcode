package Greedy_Algorithm_For_Interviews;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int []val = {60, 100, 120};
        int []wt = {10, 20, 30};
        int capacity = 50;
        double fractionalKnapsack = fractionalKnapsack(val, wt, capacity);
        System.out.println("fractionalKnapsack : "+fractionalKnapsack);
    }

    static class Item implements Comparable<Item>{
        int val;
        int wt;
        double ratio;
        Item(int v, int w){
            val = v;
            wt = w;
            ratio = (double) val/ (double) wt;
        }

        //decreasing order of ratio sort
        @Override
        public int compareTo(Item that) {
            if (this.ratio <= that.ratio) return 1;
            return -1;
        }
    }
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Item(val[i], wt[i]));
        }
        Collections.sort(list);
        double res = 0.0;
        for (Item item : list){
            if (item.wt >= capacity){
                res += (capacity * item.ratio);
                capacity = 0;
            }
            else {
                res += item.val;
                capacity -= item.wt;
            }
            if (capacity == 0) break;
        }
        return res;
    }
}

