/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

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
        System.out.println(getLCS(s1, s2));
        System.out.println(getLCS(s3, s4));
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
}
