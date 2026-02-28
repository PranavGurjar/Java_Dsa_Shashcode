package Graph_Data_Structure;

public class FloydWarshall {
    public static void main(String[] args) {

        int [][]dist = {{0, 4, 108, 5, 108},
                        {108, 0, 1, 108, 6},
                        {2, 108, 0, 3, 108},
                        {108, 108, 1, 0, 2},
                        {1, 108, 108, 4, 0}
                    };


        System.out.println("Before Floyd Warshall Algorithm : ");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                System.out.print(dist[i][j]+",  ");
            }
            System.out.println();
        }

//        floydWarshall1(dist);
        floydWarshall2(dist);

        System.out.println("After Floyd Warshall Algorithm : ");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                System.out.print(dist[i][j]+", ");
            }
            System.out.println();
        }

    }




    public static void floydWarshall1(int[][] dist) {
        //dist[i][j] == -1 no path to infinity
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1){
                    dist[i][j] = 1001;      //check the constraint and assign acc
                }
            }
        }
        //Floyd Warshall Algorithm -> O(N^3)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0){
                System.out.println("Negative Cycle Detected");
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == 1001){
                    dist[i][j] = -1;      //check the constraint and assign acc
                }
            }
        }
    }
    public static void floydWarshall2(int[][] dist) {
        int n = dist.length;
        final int INF = 100000000; // as per constraints

        // Floyd Warshall Algorithm -> O(N^3)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // skip if path through k is infinite
                    if (dist[i][k] == INF || dist[k][j] == INF)
                        continue;

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}

