/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;
import java.util.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
/**
 *
 * @author SHUBHAM
 */
public class CountTripletsGP {
    public static void main(String[] args) {
        String[] l = {"1","5","5","25","125"};
        List<Long> arr = Stream.of(l).map(Long::parseLong).collect(toList());
        System.out.println(countTriplets(arr,3));
    }
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Integer> map = new HashMap<>();
        Map<Integer, Long> map2 = new HashMap<>();
        int[] count = {0};
        arr.forEach(t-> {
            map2.put(count[0], t);
            count[0]++;
            if(map.containsKey(t)){
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        });
        for(int i=0;i<Math.ceil((double)arr.size()/r);i++){
            
        }
        return 0;
    }

}
