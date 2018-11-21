/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class TwoDArray_Minesweeper 
{
    public static void main(String[] args) 
    {
        List<int[]> bomb = new ArrayList<>();
        int[] b1 = {0,0};
        int[] b2 = {0,1};
        int[] b3 = {0,2};
        bomb.add(b1);
        bomb.add(b2);
        bomb.add(b3);
        int rows = 3;
        int col = 4;
        mine_sweeper(bomb, rows, col);
    }
    private static void mine_sweeper(List<int[]> bomb, int row, int col)
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
        printMineSweeper(mine);
    }
    private static void printMineSweeper(int[][] mine){
        for (int[] row : mine) 
            System.out.println(Arrays.toString(row)); 
    }
}