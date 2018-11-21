/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;


/**
 *
 * @author SHUBHAM
 * Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of ways to reach the given score.
 */
public class CountNoOfWaysToScore 
{
    public static void main(String[] args) 
    {
        int n=200;
        System.out.println(countWays(n));
    }
    private static int countWays(int n){
        
        int table[] = new int[n + 1], i; 

        // Base case (If given value is 0) 
        table[0] = 1; 

        for (i = 3; i <= n; i++) 
            table[i] += table[i - 3]; 
        for (i = 5; i <= n; i++) 
            table[i] += table[i - 5]; 
        for (i = 10; i <= n; i++) 
            table[i] += table[i - 10]; 
        
        return table[n]; 
    }
}
