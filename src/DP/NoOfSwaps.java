/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class NoOfSwaps 
{
    public static void main(String[] args) 
    {
        String s1 = "LOOK";
        String s2 = "WOOD";
        System.out.println(swaps(s1, s2));
    }
    private static int swaps(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] tab = new int[m+1][n+1];
        for (int i = 0; i < tab.length; i++) 
        {
            for (int j = 0; j < tab[i].length; j++) 
            {
                if (i == 0 && j == 0 ) {
                    tab[i][j] = 0;
                }
                else if (i == 0 || j == 0 ) {
                    tab[i][j] = Math.abs(j*i) + 1;
                }
                else if (tab[i][j] != tab[j][i]) {
                    int smallest = tab[i][j-1];
                    if (smallest > tab[i-1][j]) smallest = tab[i][j-1];
                    if (smallest > tab[i-1][j-1]) smallest = tab[i-1][j-1];
                    tab[i][j] = smallest + 1;
                    System.out.println(tab[i][j]);
                } 
                else {
                    tab[i][j] = tab[i-1][j-1];
                }
            }
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }
        return tab[m][n];
    }
    private static int minSwaps(String s1, String s2)
    {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) 
        {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) 
        {
            char c = s2.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                res++;
            }
        }
        return res;
    }
}
