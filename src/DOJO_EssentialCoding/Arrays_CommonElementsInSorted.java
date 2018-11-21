/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author SHUBHAM
 */
public class Arrays_CommonElementsInSorted {
    public static void main(String[] args) {
        int[] A = {1,3,4,6,7,9};
        int[] B = {1,2,4,5,9,10};
        List<Integer> C = common_Elements(A,B);
        C.forEach(System.out::println);
    }
    
    /**
     * By DOJO
     * @param A
     * @param B
     * @return 
     */
    private static List<Integer> common_Elements(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        int p1=0;
        int p2=0;
        while(p1<A.length && p2<B.length) {
            if (A[p1] == B[p2]) {
                result.add(A[p1]);
                p1 += 1;
                p2 += 1;
            }
            else if (A[p1]>B[p2]){
                p2 += 1;
            } 
            else{
                p1 += 1;
            }
        }
        return result;
    }
    
    /**
     * O(n+m)
     * @param A
     * @param B
     * @return 
     */
    private static List<Integer> commonElements(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        List<Integer> c = new ArrayList<>();
        Map<Integer, Integer> map1 = getMap(A);
        Map<Integer, Integer> map2 = getMap(B);
        map1.entrySet().forEach(e -> {
            if (map2.containsKey(e.getKey())) {
                c.add(e.getKey());
            }
        });
        return c;
    }
    
    private static Map<Integer, Integer> getMap(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        return map;
    }
}
