/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author SHUBHAM
 */

public class TwoDArray_MinesweeperExpand 
{
    public static void main(String[] args) 
    {
        List<int[]> bomb = new ArrayList<>();
        int[] b1 = {0,0};
        int[] b2 = {3,3};
        bomb.add(b1);
        bomb.add(b2);
        int row = 4;
        int col = 4;
        int[][] mine = getMine(bomb, row, col);
        int i = 0;
        int j = 2;
        mine_sweeper(mine, row, col, i, j);
        printMineSweeper(mine);
    }

    private static int[][] mine_sweeper(int[][] mine, int row, int col, int iU, int jU)
    {
        if (mine[iU][jU] == -1 || mine[iU][jU] == 1) return mine;
        
        Queue<int[]> queue = new LinkedList<>();
        int[] c = {iU, jU};
        queue.add(c);
        while(!queue.isEmpty()){
            int[] c1 = queue.peek();
            iU = c1[0];
            jU = c1[1];
            Queue<int[]> q2 = getSurroundingCoordinates(mine, row, col, iU, jU);
            queue.addAll(q2);
            queue.poll();
        }
        return mine;
    }

    private static Queue<int[]> getSurroundingCoordinates(int[][] arr, int row, int col, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        for (int i = x-1; i <= x+1; i++) 
        {
            for (int j = y-1; j <= y+1; j++)
            {
                if (i>=0 && i<row && j>=0 && j<col) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = -2;
                        int[] c = {i,j};
                        q.add(c);
                    }
                }
            }
        }
        return q;
    }
    private static int[][] getMine(List<int[]> bomb, int row, int col)
    {
        int[][] mine = new int[row][col];
        bomb.forEach(t -> {
            int row_i = t[0];
            int col_i = t[1];
            mine[row_i][col_i] = -1;
            for (int i = row_i - 1; i <= row_i + 1; i++) {
                for (int j = col_i -1; j <= col_i+1; j++) {
                    if (0<=i && i<row && j>=0 && j< col && mine[i][j] != -1) {
                        mine[i][j] += 1;
                    }
                }
            }
        });
        return mine;
    }
    private static void printMineSweeper(int[][] mine){
        for (int[] row : mine) 
            System.out.println(Arrays.toString(row)); 
    }
}
