/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Arrays;

/**
 *
 * @author SHUBHAM
 */

public class MergeSortCountingInversions {
    private static long swaps = 0;
    // Complete the countInversions function below.
    static long countInversions(int[] array) {
        int [] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return swaps;
    }
    
    private static void mergeSort(int [] array, int [] helper, int start, int end) 
    {
        if (start < end) 
        {
            int mid = (start + end) / 2;
            mergeSort(array, helper, start, mid);
            mergeSort(array, helper, mid + 1, end);
            merge(array, helper, start, mid, end);
        }
    }

    private static void merge(int [] array, int [] helper, int start, int mid, int end) 
    { 
        /* Fill helper array with same elements as original array */
        for (int i = start; i <= end; i++) 
        { // notice "i" goes from "start" to "end", not "0" to "array.length"
            helper[i] = array[i];
        }

        int curr  = start;
        int left  = start;
        int right = mid + 1;

        /* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
        while (left <= mid && right <= end) 
        {
            if (helper[left] <= helper[right]) 
            {
                array[curr++] = helper[left++];
            }
            else 
            {
                /* Each time we choose element from right side, we count up how many elements
                   it is less than from left side. This is equivalent to counting swaps. */
                swaps += mid + 1 - left;
                array[curr++] = helper[right++];
            }
        }

        /* Copy remaining elements of left half. Right half elements are already in proper place */
        while (left <= mid) 
        {
            array[curr++] = helper[left++];
        }
    }
    
    public static void main(String[] args){

            int[] arr = {2, 1, 3, 1, 2};
            int[] arr2 = {1, 1, 1, 2, 2};
            
            long result = countInversions(arr);
            System.out.println(result);
    }
}
