/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author SHUBHAM
 */
public class MaxProfit 
{
    public static void main(String[] args) 
    {
        int[] arr = {10, 18, 4, 5, 9, 6, 16, 12};
        System.out.println(maxStockProfit(arr));
    }
    private static int maxStockProfit(int[] pricesArr)
    {
        int maxProfit = -1;
        int buyPrice = 0;
        int sellPrice = 0;

        boolean changeBuyPrice = true;

        for (int i = 0; i < pricesArr.length-1; i++) 
        {
            if (changeBuyPrice)
            {
                buyPrice = pricesArr[i];
            }
            sellPrice = pricesArr[i + 1];

            if (sellPrice < buyPrice) 
            {
                changeBuyPrice = true;
            }
            else 
            {
                int tempProfit = sellPrice - buyPrice;
                if (tempProfit > maxProfit)
                {
                    maxProfit = tempProfit;
                }
                changeBuyPrice = false;
            }
        }
        return maxProfit;
    }
}
