/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;
import java.util.*;
/**
 *
 * @author SHUBHAM
 */
public class CG_2 {

    public static void main(String[] args) {
        int[] arr = {100, -70, -80, -90, 100};
        System.out.println(score(0, arr, 0));
    }

    public static int score(int index, int[] arr, int sum) {
        int k = 2;
        
        if (arr.length == 1) {
            return sum;
        }
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        List l1 = list.subList(index, index + k);
        
        int maximum = (int) Collections.max(l1);
        sum += maximum;
        index = l1.indexOf(maximum);
        
        List l2 = list.subList(index, list.size());
        int[] newArray2 = new int[l2.size()];
        for (int i = 0; i < l2.size(); i++) {
            newArray2[i] = (int) l2.get(i);
        }
        System.out.println(sum);
        return score(index + k, newArray2, sum);
    }

}
