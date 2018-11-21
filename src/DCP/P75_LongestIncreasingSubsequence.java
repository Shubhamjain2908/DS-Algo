/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;

/**
 * Microsoft
 * @author SHUBHAM
 * Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.
For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */
public class P75_LongestIncreasingSubsequence 
{
    public static void main(String[] args) 
    {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] arr2 = {10, 22, 9, 33, 21, 50, 41, 60};
        P75_LongestIncreasingSubsequence p = new P75_LongestIncreasingSubsequence();
        System.out.println(p.getLongest(arr));
    }
    
    // Brute Force, O(2^n * n)
    private int getLongest(int[] arr)
    {
        int maxLength[] = {0};
        int n = arr.length;
        int pow = (int)Math.pow(2, n) - 1;
        List<List<Integer>> powerSets = new ArrayList<>();
        for (int i = 0; i < pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n)
            {
                binary = "0" + binary;
            }
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++) 
            {
                if (binary.charAt(j) == '1') {
                    l.add(arr[j]);
                }
            }
            powerSets.add(l);
        }   
        powerSets.forEach(l -> {
            if (isValid(l)) {
                if (l.size() > maxLength[0]) {
                    maxLength[0] = l.size();
                }
            }
        });
        return maxLength[0];
    }
    private boolean isValid(List<Integer> list) 
    {
        if (list.size() == 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
