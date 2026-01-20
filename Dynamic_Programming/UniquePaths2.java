package Dynamic_Programming;

public class UniquePaths2 {
    public static void main(String[] args) {
        int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int uniquePathsWithObstacles = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("uniquePathsWithObstacles : "+uniquePathsWithObstacles);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePaths(m, n, obstacleGrid);
    }

    //bottom up space optimize approach     //T -> M*N
    public static int uniquePaths(int m, int n, int[][] obstacleGrid) {
        int prev[] = new int[n+1];

        for (int i = 1; i < m+1; i++) {
            int cur[] = new int[n+1];
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0 || obstacleGrid[i-1][j-1] == 1){      //base case
                    cur[j] = 0;
                } else if (i == 1 && j == 1) {
                    cur[j] = 1;
                }else {
                    cur[j] = prev[j] + cur[j-1];
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}

