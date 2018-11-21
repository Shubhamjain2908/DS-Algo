/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author SHUBHAM
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bub = new BubbleSort();
        int[] arr = {3,1,5,65,344,12,4,90};
        int[] a2 = bub.sortArray(arr);
        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i]);
        }
    }
    // # of passes: array.length - 1 passes
    public int[] sortArray(int[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
