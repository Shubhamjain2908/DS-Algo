/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author SHUBHAM
 */
public class MeanMedianMode {
    public static void main(String[] args) {
        MeanMedianMode m3 = new MeanMedianMode();
        int[] arr = {1,2,2,3,3,4,4,4,5,6,7,8,9,10};
        System.out.println(m3.getMean(arr));
        System.out.println(m3.getMeadian(arr));
        System.out.println(m3.getMode(arr));
        // map.keySet().forEach(key -> System.out.println(key + "->" + map.get(key)));
    }
    public Map<String, Integer> getM3(int[] arr) 
    {
        return null;
    }
    public int getMean(int[] arr) 
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum/arr.length;
    }
    public double getMeadian(int[] arr) 
    {
        double median;
        Arrays.sort(arr);
        if (arr.length%2!=0) 
        {
            median = arr[arr.length/2];
        }
        else 
        {
            median = (double)(arr[(arr.length/2) - 1] + arr[arr.length/2])/2;
        }
        return median;
    }
    public ArrayList<Integer> getMode(int[] arr) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int b1 : arr) {
            if (map.containsKey(b1)) {
                map.put(b1, map.get(b1) + 1);
            } else {
                map.put(b1, 1);
            }
        }
        // map.keySet().forEach(key -> System.out.println(key + "->" + map.get(key)));
        int maxFreq = 0;
        ArrayList<Integer> al = new ArrayList<>();
        
        for (int i = 0; i < map.size(); i++) {
            if (maxFreq != 1) {
                if (map.get(arr[i]) > maxFreq) {
                    maxFreq = map.get(arr[i]);
                    al.add(arr[i]);
                } 
                else if (map.get(arr[i]) == maxFreq) {
                    al.add(arr[i]);
                }
            }
            
        }
        
        if(al.size() == map.keySet().size()) al.clear();
        
        return al;
    }
}
