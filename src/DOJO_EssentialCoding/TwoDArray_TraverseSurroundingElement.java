/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class TwoDArray_TraverseSurroundingElement 
{
    public static void main(String[] args) 
    {
        int mat[][] = { { 1, 2, 3 }, 
                        { 5, 6, 7 }, 
                        { 9, 10, 11 },
                        { 12, 13, 14 }
                      }; 
        int x = 0;
        int y = 0;
        printSurroundingElements(mat,x,y);
    }
    public static void printSurroundingElements(int[][] arr, int x, int y) 
    {
        List<int[]> list = new ArrayList<>();
        int row = arr.length;
        for (int i = x-1; i <= x+1; i++) 
        {
            if (i<0) {
                i=0; 
            }
            int col = arr[i].length;
            for (int j = y-1; j <= y+1; j++)
            {
                if (i>=0 && j>=0 && i<=row && j<=col && arr[i][j] != arr[x][y]) {
                    int[] c = {i,j};
                    list.add(c);
                    System.out.print(" " + arr[i][j] + " ");
                    
                }
            }
            System.out.println(" ");
        }
        list.forEach(t->{
            System.out.println(Arrays.toString(t));
        });
        
    }
    public static void printArr(int[][] arr) 
    {
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(" " + arr1[j] + " ");
            }
            System.out.println(" ");
        }
    }
}
