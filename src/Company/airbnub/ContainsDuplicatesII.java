/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.airbnub;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class ContainsDuplicatesII {
    public static void main(String[] args) {
        int[] arr = {7,2,3,4,5,6,7,8,9};
        System.out.println(isContain(arr, 6));
    }
    public static boolean isContain(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && i - map.get(arr[i]) <= k) {
                return true;
            }
            map.put(arr[i], 1);
        }
        return false;
    }
}
