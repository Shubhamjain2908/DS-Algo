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
public class NonDuplicatedElement {
    public static void main(String[] args) 
    {
        int[] arr = {1,2,2,3,3,4,4,1,5};
        System.out.println(getNonDuplicatedElement(arr));
    }
    public static int getNonDuplicatedElement(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            if (map.containsKey(arr[i])) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map.entrySet().stream().findFirst().get().getKey();
    }
}
