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
 * The longest common subsequence (LCS) problem is the problem of finding the longest subsequence common to all sequences in a set of sequences (often just two sequences).
 */
public class LongestCommonSubSequence 
{
    public static void main(String[] args) 
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        String s3 = "ABCD";
        String s4 = "ADBC";
        String s5 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s6 = "DGTCGTTCGGAATGCCGTTGCTCTGTAAA";
        String s7 = "I am waiting";
        String s8 = "I've been waiting";
        System.out.println(getLCS(s1, s2));
        System.out.println(getLCS(s3, s4));
        System.out.println(getLCS2(s5, s6));
        System.out.println(getLCS2(s7, s8));
    }
    private static int getLCS(String s1, String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray(); 
        int m = c1.length;
        int n = c2.length;
        return LCS(c1, c2, m, n);
    }
    private static int LCS(char[] c1, char[] c2, int m, int n)
    {
        if (m ==0 || n==0) {
           return 0; 
        }
        if (c1[m-1] == c2[n-1]) {
            return 1+LCS(c1, c2, m-1, n-1);
        }
        return Math.max(LCS(c1, c2, m-1, n), LCS(c1, c2, m, n-1));
    }
    private static int getLCS2(String s1, String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray(); 
        int m = c1.length;
        int n = c2.length;
        return LCS2(c1, c2, m, n);
    }
    private static int LCS2(char[] X, char[] Y, int m, int n)
    {
        int L[][] = new int[m+1][n+1]; 
  
        /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
             that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++) 
        { 
          for (int j=0; j<=n; j++) 
          { 
            if (i == 0 || j == 0) 
                L[i][j] = 0; 
            else if (X[i-1] == Y[j-1]) 
                L[i][j] = L[i-1][j-1] + 1; 
            else
                L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
          } 
        }
//        for (int[] L1 : L) {
//            System.out.println(Arrays.toString(L1));
//        }
        return L[m][n]; 
    }
}
