/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class MaxProfitWithKTransactions 
{
    public static void main(String[] args) 
    {
        int[] arr = {5,11,3,50,60,90};
        int k = 2;
        System.out.println(maxProfit(arr, k));
    }
    private static int maxProfit(int[] arr, int k)
    {
        int max = 0;
        int[][] profit = new int[k+1][arr.length];
        for (int i = 0; i < arr.length; i++) 
        {
            profit[0][i] = 0;
        }
        for (int i = 0; i < profit.length; i++) 
        {
            profit[i][0] = 0;
        }
        for (int i = 1; i < profit.length; i++) 
        {
            for (int j = 1; j < profit[i].length; j++) 
            {
                profit[i][j] = Math.max(profit[i][j-1],arr[j] + maxOfPrice(arr, profit, arr.length, i));
            }
        }
        for (int i = 0; i < profit.length; i++) {
            System.out.println(Arrays.toString(profit[i]));
        }
        return max;
    }
    private static int maxOfPrice(int[] arr, int[][] profit, int k, int j)
    {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < k; i++) 
        {
            l.add(-arr[i] + profit[j-1][i]);
        }
        System.out.println(l);
        return Collections.max(l);
    }
}
