package Graph_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {

    }

    public int orangesRotting1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    freshCount++;
                }
                else if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0){
            return 0;
        }
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //level by level
            for (int i = 0; i < size; i++) {
                int []rottenLoc = queue.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];
                int [][]neighbours = {{r-1, c},{r, c+1},{r+1, c},{r, c-1}};
                for (int []neighbour : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    //out of bound //rotten - visited
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m
                            || grid[nr][nc] == 2
                            || grid[nr][nc] == 0){
                        continue;
                    }
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;   //visited
                }
            }
            time++;
            freshCount -= queue.size();
            if (freshCount == 0){
                break;
            }
        }
        return (freshCount == 0)?time:-1;
    }

    public int orangesRotting2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    freshCount++;
                }
                else if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0){
            return 0;
        }
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //level by level
            for (int i = 0; i < size; i++) {
                int []rottenLoc = queue.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];
                int [][]neighbours = {{r-1, c},{r, c+1},{r+1, c},{r, c-1}};
                for (int []neighbour : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    //out of bound //rotten - visited
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m
                            || grid[nr][nc] == 2
                            || grid[nr][nc] == 0){
                        continue;
                    }
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;   //visited
                    freshCount--;
                    if (freshCount == 0){
                        return time+1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}