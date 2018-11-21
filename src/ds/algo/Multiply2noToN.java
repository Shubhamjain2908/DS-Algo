/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class Multiply2noToN {
    public static void main(String[] args) {
        int[] arr = {4,5,6,8,2};
        int n = 20;
        int[] x = getMultiply(arr, n);
        System.out.println(x[0] + " * " + x[1]);
    }

    private static int[] getMultiply(int[] arr, int n) 
    {
        int[] x = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            int key = arr[i];
            map.putIfAbsent(key, 1);
        }
        
        for (int i = 0; i < arr.length; i++) 
        {
            int k = n/arr[i];
            if (map.containsKey(k)) {
                x[0] = arr[i];
                x[1] = k;
                return x;
            }
        }
        return null;
    }
}
