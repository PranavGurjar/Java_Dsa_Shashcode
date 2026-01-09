package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class KnightsTourProblemUsingList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> knightedTour = knightTour(5);
        System.out.println("knightedTour : "+knightedTour);
    }

    public static ArrayList<ArrayList<Integer>> knightTour(int n) {
        int sol[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(sol[i], -1);
        }
        //0th move
        sol[0][0] = 0;

        if (solve(0, 0, sol, n, 1) == true){
            return convertToList(sol, n);
        }
        else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<ArrayList<Integer>> convertToList(int[][] sol, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sol[i][j]);
            }
            result.add(row);
        }
        return result;
    }


    public static boolean solve(int i, int j, int sol[][], int N, int moves){
        //base case
        if (moves == N*N){
            return true;
        }

        int dx[] = { 2,  1, -1, -2, -2, -1,  1,  2};
        int dy[] = { 1,  2,  2,  1, -1, -2, -2, -1};

        for (int k = 0; k < 8; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];

            if (isSafe(sol, nextI, nextJ, N)){
                sol[nextI][nextJ] = moves;
                if (solve(nextI, nextJ, sol, N, moves+1) == true){
                    return true;
                }
                else {
                    sol[nextI][nextJ] = -1;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int sol[][], int i, int j, int N){
        if (i < 0 || i >= N || j < 0 || j >= N || sol[i][j] != -1){
            return false;
        }
        return true;
    }
}

