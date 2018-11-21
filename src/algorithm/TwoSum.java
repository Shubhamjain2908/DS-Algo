/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SHUBHAM
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum to = new TwoSum();
        int[] arr = {0,1,2,3,4,5,6};
        ArrayList<int[]> al2 = to.getSum(arr, 5);
        al2.forEach(array -> System.out.println(" O(n^2) : " + Arrays.toString(array)));
        ArrayList<int[]> aln = to.getSum2(arr, 5);
        aln.forEach(array -> System.out.println(" O(n) : " + Arrays.toString(array)));
    }
    // O(n^2) complexity
    public ArrayList<int[]> getSum(int[] arr, int num) 
    {
        ArrayList<int[]> al = new ArrayList<>();   
        for (int i = 0; i < arr.length/2; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] + arr[j] == num) 
                {
                    int[] i1 = new int[2];
                    i1[0] = arr[i];
                    i1[1] = arr[j];
                    al.add(i1);
                }
            }
        }
        return al;
    }
    
    // O(n) complexity
    public ArrayList<int[]> getSum2(int[] arr, int num)
    {
        ArrayList<int[]> pairs = new ArrayList<>();  
        ArrayList<Integer> hashtable = new ArrayList<>();  
        for (int i = 0; i < arr.length ; i++) {
            int current = arr[i];
            int next = num - current;
            if (hashtable.indexOf(next) != -1) {
                int[] i1 = new int[2];
                i1[0] = current;
                i1[1] = next;
                pairs.add(i1);
            }
            hashtable.add(current);
        }
        return pairs;
    } 
}
