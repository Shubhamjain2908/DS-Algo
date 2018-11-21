/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class Multiply3noToN {
    public static void main(String[] args) {
        int[] arr = {4,5,6,8,2,3,7,11};
        int n = 231;
        int[] x = getMultiply(arr, n);
        System.out.println(x[0] + " * " + x[1] + " * " + x[2]);
    }
    private static int[] getMultiply(int[] arr, int n) {
        int[] x = new int[3];
        List<Integer> arrList = getList(arr);
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) 
        {
            int k = arr[i];
            newList.addAll(arrList);
            newList.remove(i);
            //int[] newArray = removeElement(arr, i);
            List<Integer> x2 = get2Multiply(newList, n/k);
            if (!x2.isEmpty() && x2.size() == 2) {
                if ((x2.get(0) * x2.get(1) * k) == n) {
                    x[0] = x2.get(0);
                    x[1] = x2.get(1);
                    x[2] = k;
                    return x;
                }
            }
        }
        return x;
    }
    private static List<Integer> get2Multiply(List<Integer> arr, int n) 
    {
        List<Integer> x = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) 
        {
            int key = arr.get(i);
            map.putIfAbsent(key, 1);
        }
        
        for (int i = 0; i < arr.size(); i++) 
        {
            int k = n/arr.get(i);
            if (map.containsKey(k)) {
                x.add(arr.get(i));
                x.add(k);
                return x;
            }
        }
        return x;
    }
    private static List<Integer> getList(int[] arr){
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) 
        {
            l.add(arr[i]);
        }
        return l;
    }
}
