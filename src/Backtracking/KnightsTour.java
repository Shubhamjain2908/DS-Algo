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
public class KnightsTour 
{
    static int N = 8;
    
    public static void main(String[] args) 
    {
        solveKT();
    }

    private static boolean isSafe(int[][] board, int x, int y)
    {
        boolean b = (x >= 0 && x < N && y >= 0
                && y < N && board[x][y] == -1);
        return b;
    }
    
    private static boolean solveKT() 
    {
        int[][] board = new int[8][8];
        
        for (int x = 0; x < N; x++) 
            for (int y = 0; y < N; y++) 
                board[x][y] = -1; 
        printSolution(board);
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
        
        board[0][0] = 0;
        
        if (!backTrack(board,0,0,1,xMove,yMove)) 
        {
            System.out.println("Cannot be traced");
            return false;
        }
        printSolution(board);
        return true;
    }

    private static boolean backTrack(int[][] board, int x, int y, int move, int[] xMove, int[] yMove) 
    {
        if (move == 64) {
            return true;
        }
        int nextX, nextY, k;
        for (k = 0; k < 8; k++) 
        {System.out.println(x + " x:x " + xMove[k]);
        System.out.println(y + " y:y " + yMove[k]);
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            System.out.println(nextX + " n:n " + nextY);
            if (isSafe(board, nextX, nextX)) 
            {
                board[nextX][nextY] = move;
                if (backTrack(board, nextX, nextY, move+1, xMove, yMove)) {
                    return true;
                } else{
                    board[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }
    
    private static void printSolution(int sol[][]) 
    { 
        for (int x = 0; x < 8; x++) 
        { 
            for (int y = 0; y < 8; y++) 
                System.out.print(" " +x + " : "+ y + " "); 
                //System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    } 
}
