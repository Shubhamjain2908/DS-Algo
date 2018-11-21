/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author SHUBHAM
 */
public class MigratoryBirdsP {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        int[] arr = {1,2,3,4,5,4,3,2,1,3,4};//{1, 4, 4, 4, 5, 3};
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
        }
        
        System.out.println(migratoryBirds(l));
    }
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Long> map = new TreeMap<>();
        arr.forEach(t -> {
            if(!map.containsKey(t)) {
                map.put(t,(long)1);   
            } else {
                map.put(t, map.get(t)+1);   
            }
        });
        long value = map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
        List<Integer> al = new ArrayList<>();
        map.entrySet().forEach(e -> {
            if (e.getValue() == value) {
                al.add(e.getKey());
            }
        });
        return Collections.min(al);
        //return arr.stream().filter(p -> map.get(p) == value).findFirst().orElse(0);
    }
}
