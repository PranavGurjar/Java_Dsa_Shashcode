package Graph_Data_Structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int [][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] floodFillDFS1 = floodFillDFS1(image, sr, sc, color);
        System.out.println("floodFillDFS1 : "+ Arrays.deepToString(floodFillDFS1));

        int[][] floodFillDFS2 = floodFillDFS2(image, sr, sc, color);
        System.out.println("floodFillDFS2 : "+ Arrays.deepToString(floodFillDFS2));

        int[][] floodFillBFS = floodFillBFS(image, sr, sc, color);
        System.out.println("floodFillBFS : "+ Arrays.deepToString(floodFillBFS));
    }

    static int rows;
    static int cols;
    static void dfs1(int row, int col, int newColor, int curColor,
             boolean [][]visited, int [][]image){
        //out of bound cases
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || image[row][col] != curColor || visited[row][col]){
            return;
        }
        image[row][col] = newColor;
        visited[row][col] = true;
        //neighbours
        int [][]adjList = {{row-1, col},{row, col+1},{row+1, col},{row, col-1}};
        for (int []neighbour : adjList){
            dfs1(neighbour[0], neighbour[1], newColor, curColor, visited, image);
        }
    }

    public static int[][] floodFillDFS1(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        boolean [][]visited = new boolean[rows][cols]; //false
        dfs1(sr, sc, color, image[sr][sc], visited, image);
        return image;
    }

    static void dfs2(int row, int col, int newColor, int curColor, int [][]image){
        //out of bound cases
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || image[row][col] != curColor
                || image[row][col] == newColor){
            return;
        }
        image[row][col] = newColor;
        //neighbours
        int [][]adjList = {{row-1, col},{row, col+1},{row+1, col},{row, col-1}};
        for (int []neighbour : adjList){
            dfs2(neighbour[0], neighbour[1], newColor, curColor, image);
        }
    }

    public static int[][] floodFillDFS2(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        dfs2(sr, sc, color, image[sr][sc], image);
        return image;
    }

    public static int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int curColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;      //fill  / visit
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
                        || image[r][c] != curColor
                        || image[r][c] == color){
                    continue;
                }
                queue.offer(new int[]{r, c});
                image[r][c] = color;      //fill  / visit
            }
        }
        return image;
    }
}