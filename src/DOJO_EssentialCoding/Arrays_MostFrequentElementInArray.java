/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class Arrays_MostFrequentElementInArray 
{
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,1,3};
        System.out.println(mostFrequent(arr));
    }
    private static int mostFrequent(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        int key = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
            if (map.get(arr[i]) > value) {
                value = map.get(arr[i]);
                key = arr[i];
            }
        }
        return key;
    }
}
 