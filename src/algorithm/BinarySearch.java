/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Arrays;

/**
 *
 * @author SHUBHAM
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(b.search(arr, 3));
        System.out.println(b.binarySearch(arr, 1)); 
    }
    
    // O(n) complexity
    // Returns index of x if it is present in arr[], 
    // else return -1
    public int search(int[] arr, int key)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
              return i;  
            }
        }
        return -1;
    }
    
    public static boolean bs(int[] arr, int x, int left, int right){
        if (left>right) {
            return false;
        }
        int mid = left + ((right - left)/2);
        if (arr[mid] == x) {
            return true;
        } else if (x < arr[mid]) {
            return bs(arr, x, left, mid-1);
        } else {
            return bs(arr, x, mid+1, right);
        }
    }
    
    // O(logn) complexity
    public boolean binarySearch(int[] arr, int key)
    {
        return bs(arr, key, 0, arr.length-1);
//        int middleIndex = (int) Math.floor(arr.length/2);
//        int middleElem = arr[middleIndex];
//        
//        if (middleElem == key) {
//            return true;
//        }
//        else if(middleElem < key) {
//            binarySearch(Arrays.copyOfRange(arr, middleIndex+1, arr.length-1), key);
//        }
//        else if(middleElem > key) {
//            binarySearch(Arrays.copyOfRange(arr, 0, middleIndex-1), key);
//        }
//        return false;
    }
}
