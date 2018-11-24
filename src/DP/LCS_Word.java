/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author SHUBHAM
 */
public class LCS_Word 
{
    public static void main(String[] args) 
    {
        String s1 = "ABCD";
        String s2 = "AFKD";
        String s3 = "I am waiting for snow.";
        String s4 = "I've been waiting for snow.";
        String s5 = "breakfast I had tooday was awsome.";
        String s6 = "the breakfast I had today was awesome";
        String s7 = "I am waiting";
        String s8 = "I've been waiting";
        System.out.println(getLCS2(s1, s2));
        System.out.println(getLCS2(s3, s4));
        System.out.println(getLCS2(s5, s6));
        System.out.println(getLCS2(s7, s8));
    }
    private static String getLCS(String s1, String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray(); 
        String[][] memo = new String[s1.length()+1][s2.length()+1];
        return LCS(c1, c2, 0, 0, memo);
    }
    private static String LCS(char[] c1, char[] c2, int m, int n, String[][] memo)
    {
        if (m == c1.length || n == c2.length) {
            return "";
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        if (c1[m] == c2[n]) {
            memo[m][n] = String.valueOf(c1[m]) + LCS(c1, c2, m+1, n+1, memo);
            return memo[m][n];
        }
        memo[m+1][n] = LCS(c1, c2, m+1, n, memo);
        memo[m][n+1] = LCS(c1, c2, m, n+1, memo);
        return memo[m+1][n].length() > memo[m][n+1].length() ? memo[m+1][n] : memo[m][n+1];
    }
    private static String getLCS2(String s1, String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray(); 
        int m = s1.length();
        int n = s2.length();
        return LCS2(c1, c2, m, n);
    }
    private static String LCS2(char[] X, char[] Y, int m, int n)
    {
        String L[][] = new String[m+1][n+1]; 
  
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = ""; 
                else if (X[i-1] == Y[j-1]) 
                    L[i][j] = L[i-1][j-1] + X[i-1]; 
                else
                    L[i][j] = L[i-1][j].length() > L[i][j-1].length() ? L[i-1][j] : L[i][j-1];
            } 
        }
        return L[m][n]; 
    }
}
