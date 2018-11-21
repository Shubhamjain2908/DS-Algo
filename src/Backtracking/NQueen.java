/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtracking;

/**
 *
 * @author SHUBHAM
 */
public class NQueen 
{    
    public static void main(String[] args) 
    {
        NQueen q = new NQueen();
        q.solveNQ(4);
    }
    public boolean solveNQ(int n)
    {
        if (n<=3) {
            System.out.println("Cannot be solved");
            return false;
        }
        int board[][] = new int[n][n];
        if (!solveNQUntil(board, 0)) {
            System.out.println("Cannot be solved");
            return false;
        }
        
        printSolution(board);
        return true;
    }
    public boolean solveNQUntil(int[][] board, int col)
    {
        int N = board.length;
        // Base case
        if (col>=N) {
            return true;
        }
        for (int i = 0; i < N; i++) 
        {
            if (isSafe(board, i, col)) 
            {
                board[i][col] = 1;
                
                if (solveNQUntil(board, col+1)) {
                    return true;
                }
                
                board[i][col] = 0;
            }
        }
        return false;
    }
    public boolean isSafe(int[][] board, int row, int col)
    {
        int i,j;
        
        for (i = 0;  i< col; i++) 
        {
            if (board[row][i] == 1)
                return false;
        }
        
        // Upper diagonal
        for (i=row, j = col;  i>=0 && j>=0; i--,j--) 
        {
            if (board[i][j] == 1)
                return false;
        }
        
        //Lower diagonal
        for (i = row , j=col;j>=0; j--) 
        {
            if (board[i][j] == 1)
                return false;
        }
        
        return true;
    }
    public void printSolution(int[][] board)
    {
        for (int[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board1[j] + " ");
            }
            System.out.println();
        }
    }
}
