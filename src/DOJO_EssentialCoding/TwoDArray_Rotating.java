/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.Arrays;

/**
 *
 * @author SHUBHAM
 */
public class TwoDArray_Rotating 
{
    public static void main(String[] args) 
    {
        int[][] arr = {
                    {1,2,3},
                    {4,5,6},
                    {7,8,9}};
        
        //int[][] newArr = rotateArr(arr);
        rotate(arr, 3);
        printArr(arr);
    }
    public static int[][] rotate(int[][] a, int n) {
        // n/2 gives us floor(n/2)
        // and n/2 + n%2 gives us ceiling(n/2)
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int currentI = i;
                int currentJ = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = a[currentI][currentJ];
                    int[] newCoordinates = rotateSub(currentI, currentJ, n);
                    currentI = newCoordinates[0]; currentJ = newCoordinates[1];
                }
                for (int k = 0; k < 4; k++) {
                    a[currentI][currentJ] = tmp[(k + 3) % 4];
                    int[] newCoordinates = rotateSub(currentI, currentJ, n);
                    currentI = newCoordinates[0]; currentJ = newCoordinates[1];
                }
            }
        }
        return a;
    }

    public static int[] rotateSub(int i, int j, int n) {
        int[] newCoordinates = new int[2];
        newCoordinates[0] = j;
        newCoordinates[1] = n - 1 - i;
        return newCoordinates;
    }
    /**
     * Creating new Array
     * @param arr
     * @return 
     */
    private static int[][] rotateArr(int[][] arr)
    {
        int n = arr.length;
        int[][] newArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int new_i = j;
                int new_j = n-i-1;
                newArr[new_i][new_j] = arr[i][j];
            }
        }
        return newArr;
    }
    private static void printArr(int[][] arr)
    {
        for (int[] row : arr) 
            System.out.println(Arrays.toString(row)); 
    }
}
