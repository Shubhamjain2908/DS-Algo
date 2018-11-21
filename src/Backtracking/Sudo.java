/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class Sudo 
{
    final static List<List<int[]>> blockCoordinate = setBlockCoordinates();
    static int[][] game = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
    final static int N = 9;
    final static int[] nums = {1,2,3,4,5,6,7,8,9};
    static List<int[]> emptyCoordinates = getEmptyCoordinates();
    
    public static void main(String[] args) 
    {
        solveSudoku();
    }
    
    private static void solveSudoku()
    {
        if (!backTrack()) 
        {
            System.out.println("Sudoku cannot be solved!!!");
        }
        printSudoku(game);
    }
    
    private static boolean backTrack()
    {
        int i = 0, j = 0;
        boolean isThereEmptyCell = false;

        for (int ii = 0; ii < N && !isThereEmptyCell; ii++) {
            for (int jj = 0; jj < N && !isThereEmptyCell; jj++) {
                if (game[ii][jj] == 0) {
                    isThereEmptyCell = true;
                    i = ii;
                    j = jj;
                }
            }
        }
        
        // Base case
        if (!isThereEmptyCell) {
            return true;
        }
        
        for (int x = 0; x < nums.length; x++) 
        {
            if(isSuitable(i,j,nums[x]))
            {
                game[i][j] = nums[x];
                
                if (backTrack()) {
                    return true;
                }
                
                game[i][j] = 0;
            }
        }
        
        return false;
    }
    
    // assuming row and col also start at 1.  
    private static int getBlockNumber(int row, int col) 
    {
        int numMajorRows = 3;
        int numMajorCols = 3;  
        int width = 3;
        int majorRow = (row-1) / width;  // zero based majorRow
        int majorCol = (col-1) / width;  // zero based majorCol
        return majorCol + majorRow * numMajorCols + 1;
    }
    
    private static boolean isSuitable(int i, int j, int x) 
    {
        // Row
        for (int k = 0; k < 9; k++) {
            if (game[i][k] == x) return false;
        }
        
        // Column
        for (int k = 0; k < 9; k++) {
            if (game[k][j] == x) return false;
        }
        
        // Block
        int blockNo = getBlockNumber(i+1, j+1);
        List<int[]> blocks = blockCoordinate.get(blockNo-1);
        
        for (int k = 0; k < blocks.size(); k++) 
        {
            int ii = blocks.get(k)[0];
            int jj = blocks.get(k)[1];
            if (game[ii][jj] == x) return false;
        }
        return true;
    }
    
    private static List<int[]> getEmptyCoordinates()
    {
        List<int[]> e = new ArrayList<>();
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                if (game[i][j] == 0) {
                    int[] c = {i,j};
                    e.add(c);
                }
            }
        }
        return e;
    }
    
    private static List<List<int[]>> setBlockCoordinates() 
    {
        List<List<int[]>> list = new ArrayList<>();
        int i=0,j=0;
        for (int b = 0; b < 9; b++) 
        {
            List<int[]> block = new ArrayList<>();
            switch (b) {
                // 2nd Block
                case 1:
                    i=0;
                    j=3;
                    break;
                case 2:
                    i=0;
                    j=6;
                    break;
                case 3:
                    i=3;
                    j=0;
                    break;
                case 4:
                    i=3;
                    j=3;
                    break;
                case 5:
                    i=3;
                    j=6;
                    break;
                case 6:
                    i=6;
                    j=0;
                    break;
                case 7:
                    i=6;
                    j=3;
                    break;
                case 8:
                    i=6;
                    j=6;
                    break;
                default:
                    break;
            }
            for (int k = i; k < i+3; k++) {
                for (int l = j; l < j+3; l++) {
                    int[] c = {k,l};
                    block.add(c);
                }
            }
            list.add(block);
        }
        return list;
    }
    
    private static void printSudoku(int[][] game)
    {
        for (int[] game1 : game) {
            for (int j = 0; j < game1.length; j++) {
                System.out.print(game1[j] + " ");
            }
            System.out.println("");
        }
    }

}
