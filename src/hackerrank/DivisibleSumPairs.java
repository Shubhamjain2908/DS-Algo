/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashMap;

/**
 *
 * @author SHUBHAM
 */
public class DivisibleSumPairs {
    public static void main(String[] args) {
     int[] arr ={1, 3, 2, 6, 1, 2};
        System.out.println(divisibleSumPairs(6,3,arr));
    }
    public static int divisibleSumPairs(int n, int k, int[] ar) {  
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (!map.containsKey(ar[i])) 
                map.put(ar[i], 0);
            map.put(ar[i], map.get(ar[i]) + 1);
        }
        
        for (int i = 0; i < ar.length; i++) {
            if (map.containsKey(k-ar[i])) {
                count += map.get(k-ar[i]);
            }
        }
        return count;
    }
}
