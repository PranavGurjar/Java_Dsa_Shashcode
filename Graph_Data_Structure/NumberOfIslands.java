package Graph_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char [][]grid = {
                            {'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}
                        };

        int numIslandsDFS = numIslandsDFS(grid);
        System.out.println("numIslandsDFS : "+numIslandsDFS);

        int numIslandsBFS = numIslandsBFS(grid);
        System.out.println("numIslandsBFS : "+numIslandsBFS);

    }

    static int rows;
    static int cols;
    public static int numIslandsDFS (char[][] grid) {
        int isLands = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    isLands++;
                }
            }
        }
        return isLands;
    }

    private static void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        //out of bound
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        //neighbours
        int[][] adjList = {{row - 1, col}, {row, col + 1}, {row + 1, col}, {row, col - 1}};
        for (int[] neighbour : adjList) {
            dfs(neighbour[0], neighbour[1], grid, visited);
        }

    }

    public static int numIslandsBFS (char[][] grid) {
        int isLands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean [][]visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]=='1' && !visited[i][j]){
                    isLands++;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        int []node = queue.poll();
                        int row = node[0];
                        int col = node[1];
                        //neighbours
                        int [][]adjList = {{row-1, col},{row, col+1},{row+1, col},{row, col-1}};
                        for (int []neighbour : adjList){
                            int r = neighbour[0];
                            int c = neighbour[1];
                            //out of bound cases
                            if (r < 0 || r >= rows || c < 0 || c >= cols
                                    || grid[r][c] == '0' || visited[r][c]){
                                continue;
                            }
                            queue.offer(new int[]{r, c});
                            visited[r][c] = true;
                        }
                    }
                }
            }
        }
        return isLands;
    }
}


