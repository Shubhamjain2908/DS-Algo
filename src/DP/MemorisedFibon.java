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
public class MemorisedFibon {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int n = 20;
        System.out.println(fib(n));
    }
    private static int fib(int n) 
    {
        if (n==1 || n==2) {
            return 1;
        }
        if (map.containsKey(n)) return map.get(n);
        else{
            map.put(n, fib(n-1) + fib(n-2));
        }
        return map.get(n);
    }
}
