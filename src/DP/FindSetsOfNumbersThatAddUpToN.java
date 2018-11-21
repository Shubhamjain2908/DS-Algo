/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author SHUBHAM
 */
public class FindSetsOfNumbersThatAddUpToN 
{
    public static void main(String[] args) 
    {
        int n=16;
        int[] arr = {2,4,6,10};
        List<List<Integer>> list = getSets(arr,n);
        list.forEach(System.out::println);
        System.out.println(count_sets_dp(arr, n));
    }
    
    /**
     * Using Dynamic programming
     * @param arr
     * @param total
     * @return 
     */
    private static int count_sets_dp(int[] arr, int total) 
    {
        Map<String, Integer> map = new HashMap<>();
        return dp(arr, total, arr.length-1,map);
    }
    // Dyanamic programming
    private static int dp(int[] arr, int total,int i, Map<String, Integer> map) 
    {
        String key = total + ":" + i;
        int k=0;
        if (map.containsKey(key)) return map.get(key);
        if (total==0) return 1;
        else if (total<0) return 0;
        else if (i<0) return 0;
        else if (total<arr[i]) {
            k = dp(arr, total, i-1, map);
        }
        else {
            k = rec(arr, total-arr[i], i-1) + rec(arr, total, i-1);
        }
        map.put(key, k);
        return k;
    }
    
    /**
     * Brute force O(n^2)
     * @param inputArray
     * @param k
     * @return 
     */
    private static List<List<Integer>> getSets(int[] inputArray, int k)
    {   
        List<List<Integer>> al = new ArrayList<>();
        if (k<0) return null;
        if (k==0){
            al.add(new ArrayList<>());
            return al;
        }
        int n = inputArray.length;
        int pow = (int) Math.pow(2, n)-1;
        for (int i = 1; i <= pow; i++) 
        {
            List<Integer> al2 = new ArrayList<>();
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n){
                binary = "0" + binary;
            }
            int sum = 0;
            for (int j = 0; j < binary.length(); j++) 
            {
                if (binary.charAt(j) == '1') {
                    al2.add(inputArray[j]);
                    sum = sum + inputArray[j];
                }
            }
            if (sum == k) {
                al.add(al2);
            }
            
        }
        return al;
    }
    
    /**
     * Recursion
     * @param arr
     * @param total
     * @return 
     */
    private static int countSets(int[] arr, int total)
    {
        return rec(arr, total, arr.length -1);
    }
    // Recursion
    private static int rec(int[] arr, int total, int i)
    {
        if (total==0) return 1;
        else if (total<0) return 0;
        else if (i<0) return 0;
        else if (total<arr[i]) return rec(arr, total, i-1);
        else return rec(arr, total-arr[i], i-1) + rec(arr, total, i-1);
    }
    
}
