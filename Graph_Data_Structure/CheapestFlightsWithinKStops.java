package Graph_Data_Structure;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
//        Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
//        Output: 200


        int n = 3, src = 0, dst = 2, k = 1;
        int [][]flights = {{0,1,100},{1,2,100},{0,2,500}};
        int cheapestPrice1 = findCheapestPrice1(n, flights, src, dst, k);
        System.out.println("cheapestPrice1 : "+cheapestPrice1);
        int cheapestPrice2 = findCheapestPrice2(n, flights, src, dst, k);
        System.out.println("cheapestPrice2 : "+cheapestPrice2);
    }

    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        //bellmanford
        int []price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        for (int i = 0; i < k+1; i++) {
            int []temp = Arrays.copyOf(price, n);    //values
            for (int []flight : flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if (price[u] != Integer.MAX_VALUE && price[u] + w < temp[v]){
                    temp[v] = price[u] + w;
                }
            }
            price = temp;
        }
        return (price[dst] == Integer.MAX_VALUE)?-1:price[dst];
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int price;
        int stops;

        Pair(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }

        public int compareTo(Pair that) {
            return this.price - that.price;
        }
    }

    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        //Dijkstra
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int []flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2], 0));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        pq.offer(new Pair(src, 0, 0));
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curNode = cur.node;
            int curPrice = cur.price;
            int curStops = cur.stops;
            if(price[curNode] < curPrice || curStops > k) continue;
            for(Pair p : graph.get(curNode)) {
                if(price[curNode] + p.price < price[p.node] && curStops <= k) {
                    price[p.node] = price[curNode] + p.price;
                    pq.offer(new Pair(p.node, price[p.node], curStops+1));
                }
            }
        }
        if(price[dst] == Integer.MAX_VALUE) return -1;

        return price[dst];
    }
}